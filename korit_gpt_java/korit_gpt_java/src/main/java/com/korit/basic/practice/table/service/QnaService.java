package com.korit.basic.practice.table.service;

import com.korit.basic.practice.table.dto.request.QnaRequestDto;
import com.korit.basic.practice.table.dto.response.QnaResponseDto;
import com.korit.basic.practice.table.entity.Qna;

import java.util.List;

public interface QnaService {
    public void createQna(QnaRequestDto requestDto);
    public List<QnaResponseDto> allQnas();
    public void updateQna(long id, QnaRequestDto requestDto);
    public void deleteQna(long id);
}
