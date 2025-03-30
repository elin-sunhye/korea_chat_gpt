package com.korit.basic.chapter13.practice.service;

import com.korit.basic.chapter13.practice.model.Book;
import com.korit.basic.chapter13.practice.repository.BookRepository;

import java.util.List;

// 비즈니스 로직 처리 - 싱글톤 패턴으로 구현
public class BookServiceImpl implements BookManager<Book> {
    private static BookServiceImpl instance;
    private final BookRepository repository = new BookRepository(); // 생성자 private 설정때문에 생성자 안에서 초기화 X

    private BookServiceImpl() {
    }

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
        }

        return instance;
    }

    @Override
    public void addBook(Book book) {
//        id 중복 체크
        if (repository.findById(book.getId()) != null) {
//            중복 O
            System.out.println("Already added Id.");
            return;
        }

        repository.save(book);
        System.out.println(book.getTitle() + " added.");
    }

    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book findBookById(int id) {
        Book book = repository.findById(id);

        if (book == null) {
            System.out.println("Not Found Id.");
//            return null; -> 중복 코드라서 삭제
        }

        return book;
//        return repository.findById(id);
    }

    @Override
    public void updateBook(int id, Book updatedBook) {
        Book existingBook = repository.findById(id);

        if (existingBook == null) {
            System.out.println("Not Found " + "ID : " + id);
            return;
        }

        repository.deleteById(id); // 기존 도서 삭제
        repository.save(updatedBook); // 업데이트 된 도서 추가
        System.out.println("ID : " + id + " updated");
    }

    @Override
    public void removeBook(int id) {
        Book existingBook = repository.findById(id);

        if (existingBook == null) {
            System.out.println("Not Found " + "ID : " + id);
            return;
        }

        repository.deleteById(id);
        System.out.println("Deleted " + existingBook.getTitle());
    }
}
