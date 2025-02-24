package com.korit.boardback.service;

import com.korit.boardback.dto.request.ReqJoinDto;
import com.korit.boardback.entity.User;
import com.korit.boardback.exception.DuplicatedValueException;
import com.korit.boardback.exception.FieldError;
import com.korit.boardback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean duplicatedByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Transactional(rollbackFor = Exception.class)
    public User join(ReqJoinDto reqDto) {
        if(duplicatedByUsername(reqDto.getUsername())) {
            throw new DuplicatedValueException(
                    List.of(
                            FieldError.builder()
                            .field("username")
                            .msg("이미 존재하는 사용자 이름 입니다.")
                            .build()
                    )
            );
        }

        User user = User.builder()
                .username(reqDto.getUsername())
                .password(reqDto.getPassword())
                .email(reqDto.getEmail())
                .nickname(reqDto.getUsername())
                .accountExpired(1)
                .accountLocked(1)
                .credentialsExpired(1)
                .accountEnabled(1)
                .build();

        return userRepository.save(user);
    }
}
