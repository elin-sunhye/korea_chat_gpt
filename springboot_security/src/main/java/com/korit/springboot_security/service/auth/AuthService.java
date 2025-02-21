package com.korit.springboot_security.service.auth;

import com.korit.springboot_security.dto.request.auth.ReqSigninDto;
import com.korit.springboot_security.dto.response.auth.RespAuthDto;
import com.korit.springboot_security.entity.user.User;
import com.korit.springboot_security.repository.user.UserRepository;
import com.korit.springboot_security.security.jwt.JwtUtil;
import com.korit.springboot_security.service.RedisTokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTokenService redisTokenService;

    public RespAuthDto login(ReqSigninDto reqSigninDto) {
        User foundUser = userRepository.findByUsername(reqSigninDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 확인하세요"));

        if(!passwordEncoder.matches(reqSigninDto.getPassword(), foundUser.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }

        String accessToken = jwtUtil.generateToken(
                Integer.toString(
                        foundUser.getUserId()
                ),
                foundUser.getUsername(),
                false
        );
        String refreshToken = jwtUtil.generateToken(
                Integer.toString(
                        foundUser.getUserId()
                ),
                foundUser.getUsername(),
                true
        );

//        redis에 token 저장
//        기존 존재 시 덮어쓰기
        redisTokenService.setAccess(reqSigninDto.getUsername(), accessToken, Duration.ofMinutes(60));
        redisTokenService.setRefresh(reqSigninDto.getUsername(), refreshToken, Duration.ofDays(7));

        return RespAuthDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public RespAuthDto refresh(String refreshToken) {
        Claims claims = jwtUtil.parseToken(refreshToken);

        if(claims == null) {
            return null;
        }

        String userId = claims.getId();
        String username = claims.getSubject();
        String redisRefresh = redisTokenService.getRefreshToken(username);

        if(redisRefresh == null || !redisRefresh.equals(refreshToken)) {
            return null;
        }
        String newAccessToken = jwtUtil.generateToken(userId, username, false);

        return RespAuthDto.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
