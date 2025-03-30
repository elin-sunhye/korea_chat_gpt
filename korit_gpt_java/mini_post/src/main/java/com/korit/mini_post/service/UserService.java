package com.korit.mini_post.service;

import com.korit.mini_post.dto.request.ReqAddUser;
import com.korit.mini_post.dto.response.RespUserDto;
import com.korit.mini_post.entity.User;
import com.korit.mini_post.repository.UserRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public RespUserDto saveUser(ReqAddUser reqAddUser) {
        System.out.println("service" + reqAddUser);
        User user= userRepository.saveUser(reqAddUser.toUser()).orElseThrow(() -> new DuplicateKeyException("중복된 USER입니다. "));
        RespUserDto respuser = new RespUserDto(user.getUserId(), user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail());
        return respuser;
    }

    public User findByUserId(int userId) throws NotFoundException {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("해당 사용자가 없습니다."));
    }
}
