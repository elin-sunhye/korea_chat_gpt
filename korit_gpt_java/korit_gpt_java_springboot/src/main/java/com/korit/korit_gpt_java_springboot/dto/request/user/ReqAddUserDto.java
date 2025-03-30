package com.korit.korit_gpt_java_springboot.dto.request.user;

import com.korit.korit_gpt_java_springboot.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@ApiModel(description = "사용자 추가 DTO")
@Data
public class ReqAddUserDto {
    @ApiModelProperty(value = "사용자이름", example = "user123", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "4~16자의 영문자, 숫자, 밑줄(_)만 사용할 수 있으며, 공백은 포함할 수 없습니다.")
    private String username;
    @ApiModelProperty(value = "비밀번호", example = "User123456789!", required = true)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,20}$", message = "영어, 대소문자, 특수문자(!@#$%^&*)를 하나 이상 포함하여 8~20자 사용해야 합니다.")
    private String password;
    @ApiModelProperty(value = "성명", example = "김선혜", required = true)
    @Pattern(regexp = "^[가-힣]{2,}$", message = "2자 이상의 한글만 사용할 수 있습니다.")
    private String name;
    @ApiModelProperty(value = "이메일", example = "user@example.com", required = true)
    @Email(message = "이메일 형식으로 사용해야합니다.")
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
