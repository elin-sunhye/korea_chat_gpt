package com.korit.basic.chapter13.practice.model;

public abstract class Book {
    private int id;
    private String title;
    private String author;

    //    reset
//    추상 클래스 : Book
//    : 직접적인 이스천스화 X
//    : 생성자는 하위 클래스 생성자 내애서 호출 용로 정의
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //    getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //    클래스 최상위 Object 클래스에서 가져옴
    @Override
    public String toString() {
        return "ID : " + id + ", Title : " + title + ", Author : " + author;
    }
}
