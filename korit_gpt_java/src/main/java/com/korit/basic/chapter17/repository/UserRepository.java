package com.korit.basic.chapter17.repository;

import com.korit.basic.chapter17.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public Optional<User> findByUserId(String userId) {
//        Optional 클래스 : 값이 존재 할 수도 있고 존재하지 않을수도 이쓴 객체를 감싸는 Wrapper 클래스
//        +) ifPresentOrElse() 메서드
//          : Optional 객체에 대해 값이 존재할 경우 ifPresent 로직,
//              그렇지 않을 경우 OrElse 로직 처리
//          ifPresentOrElse(data -> {데이터가 존재할 경우 로직, 존재 하지않을 경우 로직})

        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
