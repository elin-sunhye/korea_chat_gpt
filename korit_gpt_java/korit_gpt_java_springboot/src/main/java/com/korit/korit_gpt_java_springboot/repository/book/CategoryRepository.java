package com.korit.korit_gpt_java_springboot.repository.book;

import com.korit.korit_gpt_java_springboot.entity.book.Category;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.mapper.book.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryMapper mapper;

//    카테고리 전체 조회
    public Optional<List<Category>> getAllCategory() {
        return mapper.selectCategoriesAll().isEmpty()
        ? Optional.empty()
        : Optional.ofNullable(mapper.selectCategoriesAll());
    }
//    카테고리 추가
    public Optional<Category> save(Category category) {
        try {
            mapper.addCategory(category);
        }catch (DuplicateKeyException e){
            throw new CustomDuplicateKeyException("이미 존재하는 카테고리명입니다.");
        }
        return Optional.of(category);
    }

//    카테고리 검색
    public Optional<List<Category>> findAllByNameContaining(String categoryName) {
        System.out.println(categoryName);
        return mapper.selectAllByNameContaining(categoryName).isEmpty()
                ? Optional.empty()
                : Optional.of(mapper.selectAllByNameContaining(categoryName));
    }
}
