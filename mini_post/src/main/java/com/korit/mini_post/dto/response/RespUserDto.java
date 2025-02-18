package com.korit.mini_post.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RespUserDto {
    @ApiModelProperty(value = "사용자 고유 번호")
    private int user_id;
    @ApiModelProperty(value = "유저 ID")
    private String username;
    @ApiModelProperty(value = "유저 비밀번호")
    private String password;
    @ApiModelProperty(value = "유저 이름")
    private String name;
    @ApiModelProperty(value = "유저 주소")
    private String email;
//    @ApiModelProperty(value = "생성 시간")
//    private String createAt;
}
