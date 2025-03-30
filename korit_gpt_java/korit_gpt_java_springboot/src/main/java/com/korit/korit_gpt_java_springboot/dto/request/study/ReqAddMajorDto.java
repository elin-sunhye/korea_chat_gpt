package com.korit.korit_gpt_java_springboot.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ApiModel(value = "학과 추가 DTO")
@Data
public class ReqAddMajorDto {
    @ApiModelProperty(value = "학과명", example = "컴퓨터공학과",required = true)
//    validation : 유효성 검사
    @Pattern(regexp = "^[가-힣]+$", message = "학과명은 공백 없이 한글만 사용할 수 있으며, 영어, 숫자, 특수문자, 띄어쓰기는 허용되지 않습니다.")
    private String majorName;
}
