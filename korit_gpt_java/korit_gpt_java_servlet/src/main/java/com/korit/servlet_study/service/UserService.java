package com.korit.servlet_study.service;

import com.korit.servlet_study.dao.UserDao;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private UserDao userDao;

    // 싱글톤
    private static UserService userService = null;

    private UserService() {
        userDao = UserDao.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }

        return userService;
    }

    public ResponseDto<?> getUser(int userId) {
        User founsUser = userDao.findById(userId);

        if (founsUser == null) {
            return ResponseDto.fail("Fail to found user");

        }
        return ResponseDto.success(userDao.findById(userId));
    }

    public List<User> getAllUsers(String searchValue) {
        if (searchValue == null || searchValue.isBlank()) {
            return userDao.findAll();
        }

        return userDao.findAllBySearchValue(searchValue);
//        return null;
    }

    public User addUser(User user) {
        Optional<User> userOptional = userDao.save(user);
        return userOptional.get();
    }
}
