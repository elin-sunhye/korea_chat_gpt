package com.korit.mini_post.dto.request;

import com.korit.mini_post.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.function.UnaryOperator;

@Data
@ApiModel(description = "사용자 추가 DTO")
public class ReqAddUser {

    @ApiModelProperty(value = "유저 ID", example = "user123", required = true)
    private String username;
    @ApiModelProperty(value = "유저 비밀번호", example = "User123!", required = true)
    private String password;
    @ApiModelProperty(value = "유저 이름", example = "홍길동", required = true)
    private String name;
    @ApiModelProperty(value = "유저 주소", example = "user123@naver.com", required = true)
    private String email;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
