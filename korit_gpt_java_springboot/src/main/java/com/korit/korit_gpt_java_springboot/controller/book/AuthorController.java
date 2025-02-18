package com.korit.korit_gpt_java_springboot.controller.book;

import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Author;
import com.korit.korit_gpt_java_springboot.service.book.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "저자 관리 Controller")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService service;

    @ApiOperation(value = "저자 전체 조회 API")
    @GetMapping("/api/study/author")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAllAuthor() throws NotFoundException {
        return ResponseEntity.ok().body(service.getAllAuthors());
    }
}
