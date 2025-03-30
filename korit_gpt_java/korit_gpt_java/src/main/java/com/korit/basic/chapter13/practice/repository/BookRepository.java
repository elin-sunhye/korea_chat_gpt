package com.korit.basic.chapter13.practice.repository;

import com.korit.basic.chapter13.practice.model.Book;

import java.util.ArrayList;
import java.util.List;

// 도서 저장, 검색 및 삭제하는 데이터 저장소
// 실제 행하는 메서드를 실행하기 위해서 DB에서 데이터를 조작하는 로직
public class BookRepository {
    private List<Book> books = new ArrayList<>(); // DB

    //    C, U
    public void save(Book book) {
        books.add(book);
    }

    //    D, U
    public void deleteById(int id) {
//        Book bookToRemove = null;
//        for (Book book : books) {
//            if (book.getId() == id) {
//                bookToRemove = book;
//                break;
//            }
//        }
//
//        if (bookToRemove != null) {
//            books.remove(bookToRemove);
//        }

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                break;
            }
        }
    }

    //    R
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null; // 해당하는 아이디에 책이 없을 경우
    }

    //    R
    public List<Book> findAll() {
        return books;
    }
}
