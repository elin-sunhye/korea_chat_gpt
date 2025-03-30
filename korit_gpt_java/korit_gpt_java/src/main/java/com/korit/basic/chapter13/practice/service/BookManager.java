package com.korit.basic.chapter13.practice.service;

import java.util.List;

/*
    도서 관리 시스템의 비즈니스 로직을 인터페이스화
    : CRUD

    실제 행하는 메서드
*/
public interface BookManager<T> {
    void addBook(T book); // C

    List<T> listAllBooks(); // 전체 조회 // R

    T findBookById(int id); // 단건 조회 // R

    void updateBook(int id, T updatedBook); // U

    void removeBook(int id); // D
}
