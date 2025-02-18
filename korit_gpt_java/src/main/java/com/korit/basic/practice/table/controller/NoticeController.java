package com.korit.basic.practice.table.controller;

import com.korit.basic.practice.table.dto.request.NoticeRequestDto;
import com.korit.basic.practice.table.dto.response.NoticeResponseDto;
import com.korit.basic.practice.table.entity.Notice;
import com.korit.basic.practice.table.service.NoticeServiceImpl;

import java.util.List;

/*
    프론트에서 받은 값을 검증! -> 서비스로 전달
 */
public class NoticeController {
    //    서비스
    private final NoticeServiceImpl service;

    public NoticeController() {
        this.service = new NoticeServiceImpl();
    }

    //    검증 메서드
    public boolean isValidRequest(NoticeRequestDto requestDto) {
        boolean isTitle = requestDto.getTitle() != null && !requestDto.getTitle().isEmpty();
        boolean isCont = requestDto.getCont() != null && !requestDto.getCont().isEmpty();

        return isTitle && isCont;
    }


    //    공지사항 등록
    public void createNoticeController(NoticeRequestDto requestDto) {
        if (isValidRequest(requestDto)) {
            service.createNotice(requestDto);
            System.out.println("Created notice");
        } else {
            System.out.println("invalid request : create notice");
        }
    }

    //    공지사항 전체 조회
    public void allNoticeController() {
        List<NoticeResponseDto> notices = service.allNotices();

        if (notices.isEmpty()) {
            System.out.println("No notices found");
        } else {
            notices.forEach(System.out::println);
        }
    }

    //    공지사항 수정
    public void updateNoticeController(long id, NoticeRequestDto requestDto) {
        if (isValidRequest(requestDto)) {
            service.updateNotice(id, requestDto);
            System.out.println("Updated notice");
        } else {
            System.out.println("invalid request : update notice");
        }
    }

    //    공지사항 삭제
    public void deleteNoticeController(long id) {
        try {
            service.deleteNotice(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
