package com.korit.korit_gpt_java_springboot.dto.response.common;

import lombok.Getter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Getter
@ApiModel(description = "실패 응답 DTO")
public class NotFoundResponseDto<T> extends ResponseDto<T> {
    @ApiModelProperty(value = "HTTP 상태 코드", example = "404")
    private final int status;
    @ApiModelProperty(value = "응답 메세지", example = "Not found data")
    private String message;

    public NotFoundResponseDto(T data) {
        super(data);
        status = 404;
        message = "Not found data";
    }
}
