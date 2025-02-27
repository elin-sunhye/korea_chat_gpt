package com.korit.boardback.repository;

import com.korit.boardback.entity.User;
import com.korit.boardback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    UserMapper userMapper;

    public Optional<User> findByUserId(int userId) {
        return Optional.ofNullable(userMapper.selectByUserId(userId));
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userMapper.selectByUsername(username));
    }

    public User save(User user) {
        userMapper.insert(user);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateProfileImg(int userId, String profileImg) {
        userMapper.updateProfileImgByUserId(userId, profileImg);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateNickname(int userId, String nickname) {
        userMapper.updateNicknameByUserId(userId, nickname);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(int userId, String password) {
        userMapper.updatePasswordByUserId(userId, password);
    }
}
