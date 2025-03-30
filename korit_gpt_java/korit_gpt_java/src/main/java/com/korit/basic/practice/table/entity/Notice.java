package com.korit.basic.practice.table.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice extends Table {
    private boolean fix; // 고정 게시물

    public Notice(Long id, String title, String cont, boolean attachedFile, boolean fix) {
        super(id, title, cont, attachedFile);
        this.fix = fix;
    }

    @Override
    public void display() {
        System.out.println(fix ? "공지사항 | [ 고정 ]" : "" + " 제목 : " + getTitle());
    }
}
