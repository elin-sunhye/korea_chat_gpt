package com.korit.korit_gpt_java_springboot.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // JSON을 객체로 변환할 때 (@RequestBody) 기본 생성자가 필수적
@AllArgsConstructor // new Book(bookId, bookName, authorId, isbn, categoryId, publisherId, bookImgUrl);처럼 한 번에 모든 값을 넣어서 객체를 생성
@Builder
public class Book {
    private int bookId;
    private String bookName;
    private int authorId;
    private String isbn;
    private int categoryId;
    private int publisherId;
    private String bookImgUrl;

//    join
    private Author author;
    private Category category;
    private Publisher publisher;

}