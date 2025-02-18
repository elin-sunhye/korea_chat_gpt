package com.korit.korit_gpt_java_springboot.dto.request.book;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSearchCategoryDto {
    @ApiModelProperty(value = "카테고리명", example = "교육", required = false)
    private String keyword = "";
}
