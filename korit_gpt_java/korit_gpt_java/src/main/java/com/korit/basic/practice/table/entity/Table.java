package com.korit.basic.practice.table.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Table {
    private Long id; // 테이블 고유 번호
    private String title;
    private String cont;
    private boolean attachedFile; // 첨부파일

    public abstract void display();
}
