package com.korit.korit_gpt_java_springboot.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
// @AllArgsConstructor // required = true
// @RequiredArgsConstructor // final 키워드 사용한 데이터 필수
@ApiModel(description = "학생 정보 조회 요청 학습 DTO")
public class ReqStudentDto {
    @NonNull
    @ApiModelProperty(value = "학생 이름", example = "김선혜", required = true)
    private final String name;

    @ApiModelProperty(value = "학생 나이", example = "30")
    private int age;
}
