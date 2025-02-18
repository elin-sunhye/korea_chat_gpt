package com.korit.basic.chapter15.boardApp.dto;

import com.korit.basic.chapter15.boardApp.entity.Board;
import lombok.Getter;

/*
    === 3. BoardRequestDto ===
    : 사용자에게 요청 받은 데이터를 정의
    - id 값을 제외한 필드 제공 (id는 백엔드에서 생성)
*/
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;

    public BoardRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Board toEntity() {
        return new Board(title, content, author);
    }
}
