package com.korit.korit_gpt_java_springboot.dto.response.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "카테고리 응답 DTO")
@Data
@AllArgsConstructor
public class RespCategoryDto {
    @ApiModelProperty(value = "카테고리 고유 ID")
    private int categoryId;
    @ApiModelProperty(value = "카테고리명")
    private String categoryName;
}
