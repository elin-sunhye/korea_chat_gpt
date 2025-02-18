package com.korit.basic.practice.table.dto.response;

import com.korit.basic.practice.table.entity.Category;
import com.korit.basic.practice.table.entity.Qna;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaResponseDto {
    private long id; // 테이블 고유 번호

    private String title;
    private String cont;
    private boolean attachedFile; // 첨부파일
    private String answer;
    private Category category;

    public QnaResponseDto(Qna qna) {
        this.id = qna.getId();
        this.title = qna.getTitle();
        this.cont = qna.getCont();
        this.attachedFile = qna.isAttachedFile();
        this.answer = qna.getAnswer();
        this.category = qna.getCategory();
    }

    public static QnaResponseDto fromEntity(Qna qna) {
        return new QnaResponseDto(qna);
    }
}
