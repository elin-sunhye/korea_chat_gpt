package com.korit.korit_gpt_java_springboot.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "교수 추가 DTO")
@Data
public class ReqAddInstructorDto {
    @ApiModelProperty(value = "교수 이름", example = "안교수", required = true)
    private String instructorName;
}
