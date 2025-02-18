package com.korit.basic.practice.table.dto.request;

import com.korit.basic.practice.table.entity.Category;
import com.korit.basic.practice.table.entity.Qna;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaRequestDto {
    private String title;
    private String cont;
    private boolean attachedFile; // 첨부파일
    private String answer;
    private Category category;

    public QnaRequestDto(String title, String cont, boolean attachedFile, String answer, Category category) {
        this.title = title;
        this.cont = cont;
        this.attachedFile = attachedFile;
        this.answer = answer;
        this.category = category;
    }

    public Qna toEntity() {
        return new Qna(null, title, cont, attachedFile, answer, category);
    }

}
