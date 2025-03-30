package com.korit.springboot_security.service.user;

import com.korit.springboot_security.entity.user.User;
import com.korit.springboot_security.repository.user.UserRepository;
import com.korit.springboot_security.repository.user.UserRoleRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //    사용자 단건 조회 by userId
    public User getUserById(int userId) throws NotFoundException {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 ID가 없습니다."));
    }

    //    사용자 전체 조회
    public List<User> getAllUsers() throws NotFoundException {
        return userRepository.findAllUsers()
                .orElseThrow(() -> new NotFoundException("조회된 사용자가 없습니다."));
    }

}