package com.korit.service;

import com.korit.entity.User;
import com.korit.repository.UserRepository;

public class UserServiceImpl  implements UserService {
    @Override
    public void add(User user) {
//        UserRepository userRepository = UserRepository.getInstance();
//        userRepository.addUer(user);

        UserRepository.getInstance().addUer(user);
    }

    @Override
    public void remove() {

    }

    @Override
    public void printInfo() {

    }
}
