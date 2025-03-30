package com.korit.korit_gpt_java_springboot.repository.book;

import com.korit.korit_gpt_java_springboot.entity.book.Author;
import com.korit.korit_gpt_java_springboot.mapper.book.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorMapper mapper;

//    저자 전체 조회
    public Optional<List<Author>> getAllAuthors() {
        return mapper.selectAuthorsAll().isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(mapper.selectAuthorsAll());
    }

//    저자 추가
//    public Optional<Author> addAuthor()
}
