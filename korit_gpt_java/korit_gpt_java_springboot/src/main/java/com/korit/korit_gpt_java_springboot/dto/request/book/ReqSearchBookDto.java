package com.korit.korit_gpt_java_springboot.dto.request.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "도서명으로 도서 검색 DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSearchBookDto {
    @ApiModelProperty(value = "도서명", example = "소나기", required = false)
    private String keyword = "";
}
