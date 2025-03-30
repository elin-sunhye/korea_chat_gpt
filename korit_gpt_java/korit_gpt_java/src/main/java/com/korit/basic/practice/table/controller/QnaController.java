package com.korit.basic.practice.table.controller;

import com.korit.basic.practice.table.dto.request.QnaRequestDto;
import com.korit.basic.practice.table.dto.response.QnaResponseDto;
import com.korit.basic.practice.table.service.QnaServiceImpl;

import java.util.List;

public class QnaController {
//    프론트 요청 검증 후 서비스로 전달
    private final QnaServiceImpl service;

    public QnaController() {
        this.service = new QnaServiceImpl();
    }

//    검증 매서드
    private boolean isValidRequest (QnaRequestDto requestDto) {
        boolean isTitle = requestDto.getTitle() != null && !requestDto.getTitle().isEmpty();
        boolean isCont = requestDto.getCont() != null && !requestDto.getCont().isEmpty();
        boolean isCategory = requestDto.getCategory() != null;

        return isTitle && isCont && isCategory;
    }

//    질문 등록
public void createQnaController(QnaRequestDto requestDto) {
        if(isValidRequest(requestDto)) {
            service.createQna(requestDto);
            System.out.println("Created Qna");
        } else {
            System.out.println("Invalid request : create qna");
        }
    }
    
//    질문 전체 조회
public void allQnaController() {
        List<QnaResponseDto> qnas = service.allQnas();
        
        if(qnas.isEmpty()) {
            System.out.println("No qnas found");
        } else {
            qnas.forEach(System.out::println);
        }
    }
    
//    질문 수정
public void updateQnaController(Long id, QnaRequestDto requestDto) {
        if(isValidRequest(requestDto)) {
            service.updateQna(id, requestDto);
            System.out.println("Updated qnas");
        } else {
            System.out.println("invalid request : update qnas");
        }
    }
    
//    질문 삭제
public void deleteQnaController(Long id) {
        try {
            service.deleteQna(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
