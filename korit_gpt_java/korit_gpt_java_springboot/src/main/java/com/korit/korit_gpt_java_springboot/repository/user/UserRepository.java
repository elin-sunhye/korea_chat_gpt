package com.korit.korit_gpt_java_springboot.repository.user;

import com.korit.korit_gpt_java_springboot.entity.user.User;
import com.korit.korit_gpt_java_springboot.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

//    사용자 추가
    public Optional<User> save(User user) {
        try {
           userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.ofNullable(user);
    }

//    사용자 단건 조회 by username
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userMapper.selectByUsername(username));
    }

//    사용자 단건 조회 by userID
    public Optional<User> findByUserId(int id) {
        return Optional.ofNullable(userMapper.selectById(id));
    }

//    사용자 전체 조회
    public Optional<List<User>> findAllUsers() {
    List<User> foundAllUser = userMapper.selectAllUsers();
    return foundAllUser.isEmpty()
            ? Optional.empty()
            : Optional.ofNullable(foundAllUser);
    }

//    사용자 수정
    public Optional<Boolean> updateUserById(User user) {
        return userMapper.updateUserById(user) < 1 ? Optional.empty() : Optional.ofNullable(true);
    }

//    사용자 삭제
    public Optional<Boolean> deleteUserById(int userId) {
        return userMapper.deleteById(userId) < 1 ? Optional.empty() : Optional.ofNullable(true);
    }
}
