package com.korit.basic.chapter13.practice.view;

import com.korit.basic.chapter13.practice.model.Book;
import com.korit.basic.chapter13.practice.model.Fiction;
import com.korit.basic.chapter13.practice.model.NonFiction;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== 도서 관리 시스템 ===");
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 전체 조회");
        System.out.println("3. 도서 단건 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("0. 종료");
        System.out.print("Choose >>");
    }

    //    사용자 입력 값에 대한 유효성 검증 로직 추가
//    : 프로세스 로직 입력 값, 데이터 입력 값 검증
    public int getInput() {
        int choice;

        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Try again. Enter the Number.");
            scanner.nextLine();
            return -1;
        }

        return choice;
    }

    public Book getBookDetails() {
        System.out.println("Book ID : ");
        int id = getInput();

        if (id == -1) return null;

        scanner.nextLine(); // 정수 값이 잘 입력된 경우 - nextInt()의 버퍼 처리

        System.out.println("Title : ");

//        cf) 문자열 메서드 - 문자열.trim()
//        : 문자열 양끝의 공백 제거
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Empty title.");
            return null;
        }

        System.out.println("Author : ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Empty author.");
            return null;
        }

        System.out.println("1. Fiction / 2.Non-Fiction");
        int type = getInput();
        if (type == -1) return null;

        scanner.nextLine();

        if (type == 1) {
            System.out.println("Genre : ");
            String genre = scanner.nextLine().trim();
            if (genre.isEmpty()) {
                System.out.println("Empty genre.");
                return null;
            }

            return new Fiction(id, title, author, genre);
        } else if (type == 2) {
            System.out.println("Field : ");
            String field = scanner.nextLine().trim();
            if (field.isEmpty()) {
                System.out.println("Empty field.");
                return null;
            }

            return new NonFiction(id, title, author, field);
        } else {
            System.out.println("Try again. Choose 1 or 2");
            return null;
        }
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No book");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("Not Found book");
        } else {
            System.out.println(book);
        }
    }
}
