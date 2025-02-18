package com.korit.servlet_study.dto;

import com.korit.servlet_study.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertBoardDto {
    private String title;
    private String content;

    //    dto를 entity 객체로 변환하는 메서드
    public Board toBoard() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
