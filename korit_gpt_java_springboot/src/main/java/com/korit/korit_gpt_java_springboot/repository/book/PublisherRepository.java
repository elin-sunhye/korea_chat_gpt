package com.korit.korit_gpt_java_springboot.repository.book;

import com.korit.korit_gpt_java_springboot.entity.book.Publisher;
import com.korit.korit_gpt_java_springboot.mapper.book.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepository {

    @Autowired
    private PublisherMapper mapper;

//    출판사 전체 조회
    public Optional<List<Publisher>> getAllPublishers() {
        return mapper.selectPublishersAll().isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(mapper.selectPublishersAll());
    }
}
