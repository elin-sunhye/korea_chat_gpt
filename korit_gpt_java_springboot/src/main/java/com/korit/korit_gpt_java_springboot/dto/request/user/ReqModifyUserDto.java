package com.korit.korit_gpt_java_springboot.dto.request.user;

import com.korit.korit_gpt_java_springboot.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@ApiModel(description = "사용자 수정 DTO")
@Data
public class ReqModifyUserDto {
    @ApiModelProperty(value = "이메일", example = "user@example.com", required = true)
    @NotNull(message = "이메일 주소를 입력해 주세요.")
    @Email(message = "이메일 형식으로 사용해야합니다.")
    private String email;

    public User toUser(int userId) {
        return User.builder()
                .userId(userId)
                .email(email)
                .build();
    }
}
