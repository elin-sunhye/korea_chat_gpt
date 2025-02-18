package com.korit.korit_gpt_java_springboot.service.book;

import com.korit.korit_gpt_java_springboot.dto.request.book.ReqAddBookDto;
import com.korit.korit_gpt_java_springboot.dto.request.book.ReqSearchBookDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Book;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.repository.book.BookRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

//    도서 전체 조회
    public SuccessResponseDto<List<Book>> getAllBooks() throws NotFoundException {
//        orElseThrow()를 호출하면 Optional<List<Book>>에서 List<Book>가 반환
        List<Book> foundAllBooks = repository.getAllBooks()
                .orElseThrow(() -> new NotFoundException("조회된 도서가 없습니다."));
        return new SuccessResponseDto<>(foundAllBooks);
    }
//    도서 추가
    public Book addBook(ReqAddBookDto reqAddBookDto) {
        return repository
                .save(reqAddBookDto.toBook())
                .orElseThrow(() -> new CustomDuplicateKeyException("이미 존재하는 도서명입니다."));
    }

//    도서명으로 도서 검색
    public List<Book> getBooks(ReqSearchBookDto reqSearchBookDto) throws Exception {
        return repository.findAllByNameContaining(reqSearchBookDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 도서가 없습니다."));
    }
}
