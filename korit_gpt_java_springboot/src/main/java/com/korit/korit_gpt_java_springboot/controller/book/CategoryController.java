package com.korit.korit_gpt_java_springboot.controller.book;

import com.korit.korit_gpt_java_springboot.dto.request.book.ReqAddCategoryDto;
import com.korit.korit_gpt_java_springboot.dto.request.book.ReqSearchCategoryDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Category;
import com.korit.korit_gpt_java_springboot.service.book.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "카테고리 관리 Controller")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @ApiOperation(value = "카테고리 전체 조회 API")
    @GetMapping("/api/study/category")
    public ResponseEntity<SuccessResponseDto<List<Category>>> getAllCategory() throws NotFoundException {
        return ResponseEntity.ok().body(service.getAllCategory());
    }

    @ApiOperation(value = "카테고리 추가")
    @PostMapping("/api/book/category")
    public ResponseEntity<SuccessResponseDto<Category>> addCategory(@Valid @RequestBody ReqAddCategoryDto reqAddCategoryDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.addCategory(reqAddCategoryDto)));
    }

    @ApiOperation(value = "카테고리 검색")
    @GetMapping("/api/book/categories")
    public ResponseEntity<SuccessResponseDto<List<Category>>> searchCategory(@ModelAttribute ReqSearchCategoryDto searchCategoryDto) throws Exception {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.getCategories(searchCategoryDto)));
    }
}
