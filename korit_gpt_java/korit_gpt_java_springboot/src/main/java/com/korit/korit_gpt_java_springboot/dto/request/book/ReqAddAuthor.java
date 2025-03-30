package com.korit.korit_gpt_java_springboot.dto.request.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@ApiModel(description = "저자 추가 DTO")
@Data
public class ReqAddAuthor {
    @ApiModelProperty(value = "저자명", example = "김선혜", required = true)
    @Pattern(regexp = "^[^0-9]+$", message = "숫자는 허용될 수 없습니다.")
    private String authorName;
}
