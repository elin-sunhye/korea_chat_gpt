package com.korit.korit_gpt_java_springboot.controller.book;

import com.korit.korit_gpt_java_springboot.dto.request.book.ReqAddBookDto;
import com.korit.korit_gpt_java_springboot.dto.request.book.ReqSearchBookDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Book;
import com.korit.korit_gpt_java_springboot.service.book.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// react(JSON, form) -> controller(JSON, form -> reqDto) -> service(reqDto -> entity) -> repository(entity)
// repository(Optional(entity)) -> service(entity -> respDto) -> controller(respDto -> respEntity)

import javax.validation.Valid;
import java.util.List;

@Api(tags = "도서 관리 Controller")
@RestController
public class BookController {

    @Autowired
    private BookService service;

    @ApiOperation(value = "도서 전체 조회 API")
    @GetMapping("/api/book")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getAllBooks() throws NotFoundException {
        return ResponseEntity.ok().body(service.getAllBooks());
    }

    @ApiOperation(value = "도서 추가")
    @PostMapping("/api/book")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@Valid @RequestBody ReqAddBookDto reqAddBookDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.addBook(reqAddBookDto)));
    }

    @ApiOperation(value = "도서 검색")
    @GetMapping("/api/books")
    public ResponseEntity<SuccessResponseDto<List<Book>>> searchBook(@ModelAttribute ReqSearchBookDto searchBookDto) throws Exception {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.getBooks(searchBookDto)));
    }
}
