package com.korit.basic.practice.table.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Qna extends Table {
    private String answer; // 질뮨에 대한 대답
    private Category category; // 질문에 대한 카테고리

    public Qna(Long id, String title, String cont, boolean attachedFile, String answer, Category category) {
        super(id, title, cont, attachedFile);
        this.answer = answer;
        this.category = category;
    }

    @Override
    public void display() {
        System.out.println("QnA | [ " + category + " ]" + getTitle());
    }
}
