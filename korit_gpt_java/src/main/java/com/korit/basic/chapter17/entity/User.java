package com.korit.basic.chapter17.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 1

@AllArgsConstructor
@Getter
public class User {
    //    수정 없음
    //    private Long id;
    //    사용자 고유 아이디
    private final String userId;
    private final String password;
    private final String name;
    private final String email;
}
