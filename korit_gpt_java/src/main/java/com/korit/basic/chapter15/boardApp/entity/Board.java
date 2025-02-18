package com.korit.basic.chapter15.boardApp.entity;

import lombok.Data;

/*
    === 1. Board 게시판 ===
    field
    - id : 게시판 고유 번호
    - title : 게지판 제목 (길이 제한 O)
    - content : 게시판 내용 (길이 제한 X)
    - author : 게시판 작성자

    **
        프론트(view)에서 요청하면 boardController에 전달
        boardController에서 받은 데이터들을 BoardRequestDto 타입으로 저장 (toEntity로 new Board에 받은 데이터 저장)하여 BoardService로 전달
        BoardService의 메서드들을 재구현한 BoardServiceImpl로 전달, 전달 받은 데이터들을 BoardRepository로 전달 이때 전달 시 Board 타입으로 전달 DB에는 Board 타입으로 저장 (해당 요청에 대한 필요한 데이터 가져오기,  저장, 수정, 삭제)
        백엔드 타입(BoardRequestDto)으로 응답(fromEntity Board에 저장된 데이터 꺼내기)하여 반환한 값을 BoardServiceImpl로 전달후 BoardServiceImpl에서 boardController에 전달 후 view에게 전달

       프론트  > 컨트롤러 > 서비스 > 리포지토리, DB > 서비스 > 컨트롤러 > 프론트

        파일 생성 : entity > repository > controller > service
    **
*/

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
