package com.korit.basic.chapter13.practice.model;

public class NonFiction extends Book {
    private String field;

    //    reset
    public NonFiction(int id, String title, String author, String field) {
        super(id, title, author);
        this.field = field;
    }

    //    getter
    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return super.toString() + ", Filed : " + field;
    }
}
