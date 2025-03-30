package com.korit.basic.chapter14.practice;

import lombok.Data;
import lombok.AllArgsConstructor;

/*
    User, SignUp(회원가입), Request(요청), Dto(데이터 변환 객체)

    DTO(Data Transfer Object)
    : 데이터 전송 객체
    : 플세스 간에 데이터를 전달하는 객체를 의미
    - 계층 간 데이터 전송을 위해 사용하는 객체
*/
@Data
@AllArgsConstructor
public class UserSignUpRequestDto {
    private String userId;
    private String password;
    private String passwordCheck;
    private String userName;
    private String email;
    private String phone;
    private String nickName;
}
