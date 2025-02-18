package com.korit.korit_gpt_java_springboot.service.book;

import com.korit.korit_gpt_java_springboot.dto.request.book.ReqAddCategoryDto;
import com.korit.korit_gpt_java_springboot.dto.request.book.ReqSearchCategoryDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Category;
import com.korit.korit_gpt_java_springboot.repository.book.CategoryRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

//    카테고리 전체 조회
        public SuccessResponseDto<List<Category>> getAllCategory() throws NotFoundException {
            return new SuccessResponseDto<>(
                    repository.getAllCategory().orElseThrow(() -> new NotFoundException("조회된 카테고리가 없습니다."))
            );
        }
//    카테고리 추가
        public Category addCategory(ReqAddCategoryDto reqAddCategoryDto) {
            return repository
                .save(reqAddCategoryDto.toCategory())
                .get();
        }

//    카테고리 검색
    public List<Category> getCategories(ReqSearchCategoryDto reqSearchCategoryDto) throws Exception {
        return repository.findAllByNameContaining(reqSearchCategoryDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 카테고리가 없습니다."));
    }
}
