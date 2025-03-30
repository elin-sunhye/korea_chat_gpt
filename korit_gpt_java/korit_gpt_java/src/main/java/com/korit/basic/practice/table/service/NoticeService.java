package com.korit.basic.practice.table.service;

import com.korit.basic.practice.table.dto.request.NoticeRequestDto;
import com.korit.basic.practice.table.dto.response.NoticeResponseDto;
import com.korit.basic.practice.table.entity.Notice;

import java.util.List;

public interface NoticeService {

    void createNotice(NoticeRequestDto requestDto);

    List<NoticeResponseDto> allNotices();

    void updateNotice(long id, NoticeRequestDto requestDto);

    void deleteNotice(long id);
}
