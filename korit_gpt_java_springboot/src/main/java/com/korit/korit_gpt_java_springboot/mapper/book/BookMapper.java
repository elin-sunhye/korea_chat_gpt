package com.korit.korit_gpt_java_springboot.mapper.book;

import com.korit.korit_gpt_java_springboot.entity.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
//    도서 전체 조회
    List<Book> selectBooksAll();

//    도서 추가
    int insert(Book book);

//    도서검색
    List<Book> selectAllByNameContaining(@Param(value = "bookName") String bookName);
}
