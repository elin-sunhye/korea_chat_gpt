package com.korit.korit_gpt_java_springboot.service.user;

import com.korit.korit_gpt_java_springboot.dto.request.user.ReqAddUserDto;
import com.korit.korit_gpt_java_springboot.dto.request.user.ReqModifyUserDto;
import com.korit.korit_gpt_java_springboot.entity.book.Book;
import com.korit.korit_gpt_java_springboot.entity.user.User;
import com.korit.korit_gpt_java_springboot.entity.user.UserRole;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.repository.user.UserRepository;
import com.korit.korit_gpt_java_springboot.repository.user.UserRoleRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

//    사용자 추가
    @Transactional(rollbackFor = Exception.class)
    public User addUser(ReqAddUserDto reqAddUserDto) {
        User saveUser = userRepository.save(reqAddUserDto.toUser())
                .orElseThrow(() -> new CustomDuplicateKeyException("", Map.of("username", "이미 사용중인 사용자 이름입니다.")));
        userRoleRepository.save(UserRole.builder()
                .userId(saveUser.getUserId())
                .roleId(1) // roleId(1) == ROLE_USER
                .build()).orElseThrow(() -> new RuntimeException("SQL Error"));
        return saveUser;
    }

//    사용자 username 중복 확인
    public boolean duplicateUsername(String username) {
//        isPresent() : 값이 있으면 true
//        isEmpty() : 값이 없으면 true
        return userRepository.findByUsername(username).isPresent();
    }

//    사용자 단건 조회 by userId
    public User getUserById(int userId) throws NotFoundException {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 ID가 없습니다."));
    }

//    사용자 전체 조회
    public List<User> getAllUsers() throws NotFoundException {
        return userRepository.findAllUsers()
                .orElseThrow(() -> new NotFoundException("조회된 사용자가 없습니다."));
    }

//    사용자 수정
    @Transactional(rollbackFor = Exception.class)
    public Boolean modifyUser(int userId, ReqModifyUserDto reqModifyUserDto) throws NotFoundException {
        return userRepository.updateUserById(reqModifyUserDto.toUser(userId))
                .orElseThrow(() -> new NotFoundException("조회된 사용자가 없습니다."));
    }

//    사용자 삭제
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUser(int userId) throws NotFoundException {
        return userRepository.deleteUserById(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 ID가 없습니다."));
    }
}
