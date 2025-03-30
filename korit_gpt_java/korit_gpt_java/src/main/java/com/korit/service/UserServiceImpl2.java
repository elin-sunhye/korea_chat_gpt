package com.korit.service;

import com.korit.entity.User;
import com.korit.repository.UserRepository;

public class UserServiceImpl2 implements UserService {
    @Override
    public void add(User user) {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUer(user);
    }

    @Override
    public void remove() {

    }

    @Override
    public void printInfo() {

    }
}
