package com.korit.basic.practice.table.service;

import com.korit.basic.practice.table.dto.request.QnaRequestDto;
import com.korit.basic.practice.table.dto.response.QnaResponseDto;
import com.korit.basic.practice.table.entity.Qna;
import com.korit.basic.practice.table.repository.QnaRepository;

import java.util.List;
import java.util.stream.Collectors;

// repository에서 데이터를 가져와 실행

public class QnaServiceImpl implements QnaService{

    private final QnaRepository repository;

    public QnaServiceImpl() {
        this.repository = new QnaRepository();
    }


    @Override
    public void createQna(QnaRequestDto requestDto) {
        Qna qna = requestDto.toEntity();
        repository.save(qna);
    }

    @Override
    public List<QnaResponseDto> allQnas() {
        List<Qna> allQnas = repository.allQnas();

        List<QnaResponseDto> responseDtos = allQnas.stream()
                .map(QnaResponseDto::fromEntity)
                .collect(Collectors.toList());

        return responseDtos;
    }

    @Override
    public void updateQna(long id, QnaRequestDto requestDto) {
        Qna findByQna = repository.
                findById(id).orElseThrow(() -> new IllegalArgumentException("not found ID : " + id));

        findByQna.setTitle(requestDto.getTitle());
        findByQna.setCont(requestDto.getTitle());
        findByQna.setAttachedFile(requestDto.isAttachedFile());
        findByQna.setAnswer(requestDto.getAnswer());
        findByQna.setCategory(requestDto.getCategory());
    }

    @Override
    public void deleteQna(long id) {
        if(repository.findById(id) != null) {
            repository.delete(id);
        } else {
            System.out.println("not found ID : " + id);
        }
    }
}
