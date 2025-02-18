package com.korit.korit_gpt_java_springboot.dto.response.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "저자 응답 DTO")
@Data
@AllArgsConstructor
public class RespAuthorDto {
    @ApiModelProperty(value = "저자 고유 ID")
    private int authorId;
    @ApiModelProperty(value = "저자명")
    private String authorName;
}
