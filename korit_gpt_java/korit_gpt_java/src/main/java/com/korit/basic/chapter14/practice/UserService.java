package com.korit.basic.chapter14.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static User signUp(UserSignUpRequestDto dto) {
//        유효성 검증
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();
        if (!password.equals(passwordCheck)) {
            throw new Error("비밀번호와 비밀번호 확인이 일치 하지 않습니다.");
        }

        Long id = 1L;
        Date nowDate = new Date();

        User user = User.builder()
                .id(id)
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .nickName(dto.getNickName())
                .signUpDate(nowDate)
                .build();

        return user;
    }

    public static void main(String[] args) {
        UserSignUpRequestDto dto1 = new UserSignUpRequestDto(
                "123",
                "1234",
                "1234",
                "이승아,",
                "qwe",
                "01022223333",
                "개구리"
        );

        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate());

        List<User> userList = null;
        List<UserSignUpRequestDto> dtos = new ArrayList<>();
        dtos.add(new UserSignUpRequestDto("123",
                "1234",
                "1234",
                "이승아1,",
                "qwe",
                "01022223333",
                "개구리")
        );
        dtos.add(new UserSignUpRequestDto("123",
                "1234",
                "1234",
                "이승아2,",
                "qwe",
                "01022223333",
                "개구리")
        );
        dtos.add(new UserSignUpRequestDto("123",
                "1234",
                "1234",
                "이승아3,",
                "qwe",
                "01022223333",
                "개구리")
        );

        userList = dtos.stream()
//                .map(dto -> signUp(dto))
                .map(UserService::signUp)
                .collect(Collectors.toList());

        userList.forEach(System.out::println);
    }
}
