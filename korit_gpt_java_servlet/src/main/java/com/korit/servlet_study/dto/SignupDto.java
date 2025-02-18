package com.korit.servlet_study.dto;

import com.korit.servlet_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    private String username;
    private String password;
    private String name;
    private String email;

    public User toUser() {
        return User.builder()
                .username(username)
//                gensalt(10) 내의 숫자가 크면 클 수록 정교한 암호화!
//                대신 암호화 및 해석 시 오래 걸림
                .password(BCrypt.hashpw(password, BCrypt.gensalt(10)))
                .name(name)
                .email(email)
                .build();
    }
}
