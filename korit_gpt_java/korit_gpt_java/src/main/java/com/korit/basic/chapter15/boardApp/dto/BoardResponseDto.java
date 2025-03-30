package com.korit.basic.chapter15.boardApp.dto;

import com.korit.basic.chapter15.boardApp.entity.Board;
import lombok.Getter;
import lombok.ToString;

/*
    === 2. BoardResponseDto ===
    : DB의 게시판 데이터 중 사용자에게 응답으로 전달할 객체 구조
    - content 값을 제외한 필드 제공 (게시판 목록에는 내용이 필요 없기 때문)
*/
@Getter
@ToString
public class BoardResponseDto {
    private Long id;
    private String title;
    private String author;

    public static BoardResponseDto fromEntity(Board board) {
        return new BoardResponseDto(board);
    }

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }
}
