package com.korit.korit_gpt_java_springboot.controller.book;

import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Publisher;
import com.korit.korit_gpt_java_springboot.service.book.PublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "출판사 관리 Controller")
@RestController
public class PublisherController {

    @Autowired
    private PublisherService service;

    @ApiOperation(value = "출판사 전체 조회 API")
    @GetMapping("/api/study/publisher")
    public ResponseEntity<SuccessResponseDto<List<Publisher>>> getAllPublishers() throws NotFoundException {
        return ResponseEntity.ok().body(service.getAllPublishers());
    }

}
