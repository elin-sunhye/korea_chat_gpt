package com.korit.korit_gpt_java_springboot.mapper.book;

import com.korit.korit_gpt_java_springboot.entity.book.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

//    카테고리 전체 조회
    List<Category> selectCategoriesAll();

//    카테고리 추가
    int addCategory(Category category);

//    카테고리 검색
    List<Category> selectAllByNameContaining(@Param(value = "categoryName") String categoryName);

}
