package com.korit.korit_gpt_java_springboot.service.book;

import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Publisher;
import com.korit.korit_gpt_java_springboot.repository.book.PublisherRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository repository;

//    출판사 전체 조회
    public SuccessResponseDto<List<Publisher>> getAllPublishers() throws NotFoundException {
        List<Publisher> foundAllPublishers = repository.getAllPublishers()
                .orElseThrow(() -> new NotFoundException("조회된 출판사가 없습니다."));
        return new SuccessResponseDto<>(foundAllPublishers);
    }
}
