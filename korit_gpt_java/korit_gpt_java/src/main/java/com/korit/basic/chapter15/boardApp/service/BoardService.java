package com.korit.basic.chapter15.boardApp.service;

import com.korit.basic.chapter15.boardApp.dto.BoardRequestDto;
import com.korit.basic.chapter15.boardApp.dto.BoardResponseDto;

import java.util.List;

/*
    === 7. BoardService ===
 */

public interface BoardService {
    List<BoardResponseDto> findAll();

    BoardResponseDto findById(long id);

    void save(BoardRequestDto boardRequestDto);

    void update(long id, BoardRequestDto boardRequestDto);

    void delete(long id);
}
