package com.korit.korit_gpt_java_springboot.dto.response.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "book 응답 DTO")
@Data
@AllArgsConstructor // Controller, Service 계층에서 DTO를 반환할 때 빠르게 객체를 만들 수 있음
public class RespBookDto {
    @ApiModelProperty(value = "도서 고유 ID")
    private int bookId;
    @ApiModelProperty(value = "도서명")
    private String bookName;
    @ApiModelProperty(value = "저자 ID")
    private int authorId;
    @ApiModelProperty(value = "도서 isbn")
    private String isbn;
    @ApiModelProperty(value = "카테고리 ID")
    private int categoryId;
    @ApiModelProperty(value = "출판사 ID")
    private int publisherId;
    @ApiModelProperty(value = "도서 표지 이미지 URL")
    private String bookImgUrl;
}
