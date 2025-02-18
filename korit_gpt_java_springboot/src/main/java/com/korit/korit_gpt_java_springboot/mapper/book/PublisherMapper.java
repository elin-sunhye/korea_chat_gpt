package com.korit.korit_gpt_java_springboot.mapper.book;

import com.korit.korit_gpt_java_springboot.entity.book.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {

//    출판사 전체 조회
    List<Publisher> selectPublishersAll();

}
