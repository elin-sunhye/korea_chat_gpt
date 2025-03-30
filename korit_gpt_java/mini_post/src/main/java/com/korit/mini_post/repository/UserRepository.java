package com.korit.mini_post.repository;

import com.korit.mini_post.entity.User;
import com.korit.mini_post.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserMapper mapper;


    public Optional<User> saveUser(User user) {
        try {
            System.out.println("repository" + user);
            mapper.insert(user);
        } catch (DuplicateKeyException e) {
            Optional.empty();
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findByUserId(int userId) {
        return Optional.ofNullable(mapper.selectByUserId(userId)).isEmpty() ? Optional.empty() : Optional.ofNullable(mapper.selectByUserId(userId));
    }
}
