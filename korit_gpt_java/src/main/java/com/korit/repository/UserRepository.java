package com.korit.repository;

import com.korit.entity.User;

import java.util.ArrayList;
import java.util.List;

/*
    저장소는 무조건 하나 -> 싱글톤
 */

public class UserRepository {
    private static UserRepository instance;

    private List<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    public void addUer(User user) {
        userList.add(user);
    }

}
