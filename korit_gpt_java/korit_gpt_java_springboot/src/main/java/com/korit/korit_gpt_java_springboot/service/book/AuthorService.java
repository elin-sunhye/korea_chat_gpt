package com.korit.korit_gpt_java_springboot.service.book;

import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.book.Author;
import com.korit.korit_gpt_java_springboot.repository.book.AuthorRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

//    저자 전체 조회
    public SuccessResponseDto<List<Author>> getAllAuthors() throws NotFoundException {
         List<Author> foundAllAuthor = repository.getAllAuthors()
                 .orElseThrow(() -> new NotFoundException("조회된 저자가 없습니다."));
         return new SuccessResponseDto<>(foundAllAuthor);
    }

}
