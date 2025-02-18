package com.korit.korit_gpt_java_springboot.mapper.book;

import com.korit.korit_gpt_java_springboot.entity.book.Author;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {

//    저자 전체 조회
    List<Author> selectAuthorsAll();

//    저자 추가
    int addAuthor(Author author);
}
