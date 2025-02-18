package com.korit.korit_gpt_java_springboot.repository.book;

import com.korit.korit_gpt_java_springboot.entity.book.Book;
import com.korit.korit_gpt_java_springboot.mapper.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookMapper mapper;

//    도서 전체 조회
    public Optional<List<Book>> getAllBooks() {
//        조회하였을때 도서가 하나도 없다면 빈 Optional 보내기
        return mapper.selectBooksAll().isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(mapper.selectBooksAll());
    }
//    도서 추가
    public Optional<Book> save(Book book) {
        try {
            mapper.insert(book);
        }catch (DuplicateKeyException e){
            return Optional.empty();
        }
        return Optional.of(book);
    }

//    도서명으로 도서 검색
    public Optional<List<Book>> findAllByNameContaining(String bookName) {
        System.out.println(bookName);
        return mapper.selectAllByNameContaining(bookName).isEmpty()
                ? Optional.empty()
                : Optional.of(mapper.selectAllByNameContaining(bookName));
    }
}
