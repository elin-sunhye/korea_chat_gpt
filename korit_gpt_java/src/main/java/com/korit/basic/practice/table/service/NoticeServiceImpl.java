package com.korit.basic.practice.table.service;

import com.korit.basic.practice.table.dto.request.NoticeRequestDto;
import com.korit.basic.practice.table.dto.response.NoticeResponseDto;
import com.korit.basic.practice.table.entity.Notice;
import com.korit.basic.practice.table.repository.NoticeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    컨트롤러에서 받은 요청 처리 (데이터베이스에서 데이터 가져와서 처리)
 */
public class NoticeServiceImpl implements NoticeService {
    //    repository
    private final NoticeRepository repository;

    public NoticeServiceImpl() {
        this.repository = new NoticeRepository();
    }

    @Override
    public void createNotice(NoticeRequestDto requestDto) {
        Notice notice = requestDto.toEntity();
        repository.save(notice);
    }

    @Override
    public List<NoticeResponseDto> allNotices() {
        List<Notice> allNotices = repository.allNotice();

//          응답 객체로 변환
        List<NoticeResponseDto> responseDtos = allNotices.stream()
                .map(NoticeResponseDto::fromEntity)
                .collect(Collectors.toList());

        return responseDtos;
    }

    @Override
    public void updateNotice(long id, NoticeRequestDto requestDto) {
        Notice findByNotice = repository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("not found ID : " + id));

        findByNotice.setTitle(requestDto.getTitle());
        findByNotice.setCont(requestDto.getCont());
        findByNotice.setAttachedFile(requestDto.isAttachedFile());
        findByNotice.setFix(requestDto.isFix());
    }

    @Override
    public void deleteNotice(long id) {
        if (repository.findById(id) != null) {
            repository.delete(id);
        } else {
            System.out.println("not found ID : " + id);
        }

    }
}
