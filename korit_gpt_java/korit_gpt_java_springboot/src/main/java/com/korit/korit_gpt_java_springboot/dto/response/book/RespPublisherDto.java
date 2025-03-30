package com.korit.korit_gpt_java_springboot.dto.response.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "출판사 응답 DTO")
@Data
@AllArgsConstructor
public class RespPublisherDto {
    @ApiModelProperty(value = "출판사 고유 ID")
    private int publisherId;
    @ApiModelProperty(value = "출판사명")
    private String publisherName;
}
