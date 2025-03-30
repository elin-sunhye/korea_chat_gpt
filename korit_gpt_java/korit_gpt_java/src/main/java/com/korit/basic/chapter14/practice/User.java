package com.korit.basic.chapter14.practice;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

//    사용자 객체 정의
@Getter
@Builder
public class User {
    private long id; // 사용자 데이터의 구분값
    private String name;
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String phone;
    private String nickName;
    private Date signUpDate; // 회원 가입 날짜 저장
}
