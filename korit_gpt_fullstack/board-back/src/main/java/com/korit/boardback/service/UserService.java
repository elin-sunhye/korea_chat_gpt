package com.korit.boardback.service;

import com.korit.boardback.dto.request.ReqJoinDto;
import com.korit.boardback.dto.request.ReqLoginDto;
import com.korit.boardback.dto.response.RespTokenDto;
import com.korit.boardback.entity.User;
import com.korit.boardback.entity.UserRole;
import com.korit.boardback.exception.DuplicatedValueException;
import com.korit.boardback.exception.FieldError;
import com.korit.boardback.repository.UserRepository;
import com.korit.boardback.repository.UserRoleRepository;
import com.korit.boardback.security.jwt.JwtUtil;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User getUserByUsername(String username) throws NotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("사용자를 찾울 수 업습니다."));
    }

    public boolean duplicatedByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Transactional(rollbackFor = Exception.class)
    public User join(ReqJoinDto reqDto) {
        if(duplicatedByUsername(reqDto.getUsername())) {
            throw new DuplicatedValueException(
                    List.of(
                            FieldError.builder()
                            .field("username")
                            .msg("이미 존재하는 사용자 이름 입니다.")
                            .build()
                    )
            );
        }

        User user = User.builder()
                .username(reqDto.getUsername())
                .password(passwordEncoder.encode(reqDto.getPassword()))
                .email(reqDto.getEmail())
                .nickname(reqDto.getUsername())
                .accountExpired(1)
                .accountLocked(1)
                .credentialsExpired(1)
                .accountEnabled(0)
                .build();
        userRepository.save(user);

        UserRole userRole = UserRole.builder()
                .userId(user.getUserId())
                .roleId(1)
                .build();
        userRoleRepository.save(userRole);

        try {
            emailService.sendAuthMail(reqDto.getEmail(), reqDto.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public RespTokenDto login(ReqLoginDto dto) {
        String accessToken = null;
        String refreshToken = null;

//        받아온 dto username과 같은 user 정보가 있는지 확인 -> 없으면 에러 터짐
        User foundUser = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("시용자 정보를 확인하세요 :)"));

//        찾은 user 정보의 password랑 받아온 dto password 확인 -> 같지 않으면 에러 터짐
        if(!passwordEncoder.matches(dto.getPassword(), foundUser.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요.");
        }

//        이메일 인증 여부 -> 0은 인증 안됨 1은 인증되었음
        if (foundUser.getAccountEnabled() == 0) {
           throw new DisabledException("이메일 인증이 필요합니다.");
        }

//        user 정보도 있고 password도 같다면 jwtUtil로 accessToken refreshToken 생성
        Date expires = new Date(new Date().getTime() + (1000l * 60 * 60 * 24 * 7));
        accessToken = jwtUtil.generateToken(Integer.toString(foundUser.getUserId()), foundUser.getUsername(), expires);
        refreshToken = jwtUtil.generateToken(Integer.toString(foundUser.getUserId()), foundUser.getUsername(), expires);

        return RespTokenDto.builder()
                .type("JWT")
                .name("AccessToken")
                .token(accessToken)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateProfileImg(User user, MultipartFile file) {
        final String PROFILE_IMG_FILE_PATH = "/upload/user/profile";
        String saveFilename = fileService.saveFile(PROFILE_IMG_FILE_PATH, file); // 폴더에 저정
        userRepository.updateProfileImg(user.getUserId(), saveFilename); // 서버에 저장

//        이전 이미지가 있는지 없는지 확인
        if(user.getProfileImg() == null) {
            return;
        }
        fileService.delFile(PROFILE_IMG_FILE_PATH + "/" + user.getProfileImg()); // 폴더에 있는 이전 이미지 삭제
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateNickname(User user, String nickname) {
        userRepository.updateNickname(user.getUserId(), nickname);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(User user, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        userRepository.updatePassword(user.getUserId(), encodedPassword);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateEmail(User user, String email) {
        userRepository.updateEmail(user.getUserId(), email);
    }
}
