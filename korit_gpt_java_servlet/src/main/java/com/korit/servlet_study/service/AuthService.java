package com.korit.servlet_study.service;

import com.korit.servlet_study.dao.AuthDao;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.dto.SigninDto;
import com.korit.servlet_study.dto.SignupDto;
import com.korit.servlet_study.entity.User;
import com.korit.servlet_study.security.jwt.JwtProvider;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    private AuthDao authDao;
    private JwtProvider jwtProvider;

    public static AuthService instance;

    private AuthService() {
        authDao = AuthDao.getInstance();
        jwtProvider = JwtProvider.getInstance();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }

        return instance;
    }

    public ResponseDto<?> signup(SignupDto dto) {
        User user = dto.toUser();
        User insertedUser = authDao.signup(user);

//        응답
        if (insertedUser == null) {
            return ResponseDto.fail("Fail to signup");
        }
        return ResponseDto.success(insertedUser);
    }

    public ResponseDto<?> signin(SigninDto dto) {
        User foundUser = authDao.findUserByUsername(dto.getUsername());

//        || 으로 합치면 안됨 null pointException 뜸
//        무조건 아이디 찾고! 아이디가 잇을 경우만! password 비교
        if (foundUser == null) {
            return ResponseDto.fail("Fail to found user");
        }

        if (!BCrypt.checkpw(dto.getPassword(), foundUser.getPassword())) {
            return ResponseDto.fail("Fail to found user");
        }

//        응답 떄 토큰 생성하여 전달
        return ResponseDto.success(jwtProvider.generateToken(foundUser));
    }
}
