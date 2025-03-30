package com.korit.basic.chapter13.practice.controller;

import com.korit.basic.chapter13.practice.model.Book;
import com.korit.basic.chapter13.practice.service.BookServiceImpl;
import com.korit.basic.chapter13.practice.view.BookView;

import java.util.List;

// 사용자의 요청 처리
public class BookController {
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getInput(); // 숫자 값을 검증하여 가져오는 메서드

            switch (choice) {
                case 1: // 책 추가 : 요청 데이터 O / 반환 데이터 X
                    Book book = view.getBookDetails();
                    if (book != null) service.addBook(book);
                    else System.out.println("Empty necessary");
//                    service.addBook(view.getBookDetails());
                    break;
                case 2: // 전체 책 조회 : 요청 데이터 X / 반환 데이터 O
                    List<Book> books = service.listAllBooks();

                    view.displayBooks(books);
                    break;
                case 3: // 단건 책 조회 : 요청 데이터 O / 반환 데이터 O
                    int findBookId = view.getInput(); // 검색하고자 하는 Book id
                    if (findBookId != -1) {
                        Book findBook = service.findBookById(findBookId); // 해당 id호 찾은 Book 객체
                        view.displayBook(findBook); // 객체 반환
                    } else {
                        System.out.println("Not Found Id");
                    }
//                    view.displayBook(service.findBookById(view.getInput()));
                    break;
                case 4: // 책 수정 : 요청 데이터 O / 반환 데이터 X
                    int modifiedId = view.getInput();

                    if (modifiedId != -1) {
                        Book updatedBook = view.getBookDetails();

                        if (updatedBook != null) {
                            service.updateBook(modifiedId, updatedBook);
                        } else {
                            System.out.println("Not Found Book");
                        }
                    } else {
                        System.out.println("Not Found Id");
                    }
                    break;
                case 5:
                    int removedId = view.getInput();

                    if (removedId != -1) service.removeBook(removedId);
                    else System.out.println("Not Found Id");

//                    service.removeBook(view.getInput());
                    break;
                case 0:
                    System.out.println("=== Quit ===");
                    return;
                default:
                    System.out.println("try again");
                    break;
            }
        }
    }

}
