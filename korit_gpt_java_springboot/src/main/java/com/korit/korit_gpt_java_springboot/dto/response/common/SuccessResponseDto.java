package com.korit.korit_gpt_java_springboot.dto.response.common;

import lombok.Getter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Getter
@ApiModel(description = "성공 응답 DTO")
public class SuccessResponseDto<T> extends ResponseDto<T> {
    @ApiModelProperty(value = "HTTP 상태 코드", example = "200")
    private final int status;
    @ApiModelProperty(value = "응답 메세지", example = "Success request")
    private String message;

    public SuccessResponseDto(T data) {
        super(data);
        status = 200;
        message = "Success request";
    }
}
