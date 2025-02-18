package com.korit.basic.chapter07;

/*
     === 도서 관리 시스템 ===
     : 책의 정보를 저장, 책의 상태(대여 가능 여부) 확인, 책 정보 출력
     1) Book 클래스
     속성: title, author, isAvailable
     메서드 : 생성자(title, author), borrowBook(), returnBook(), displayInfo()

     2) EBook 클래스
     속성 : fileSize
     메서드 : 생성자(title, author, fileSize), 오버라이딩(displayInfo  fileSize)
     +) Book 클래스의 returnBook() final 적용 : 오버라이딩 X
 */

class Book {
    private String title;
    private String author;
    private Boolean isAvailable = true; // 초기값 대여 가능 true

//    Book() {
//    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
//        isAvailable = true; // 초기값 할당 다른 방법
    }

    //    책 대여
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("대여가 완료되었습니다.");

        } else {
            System.out.println("현재 대여 중입니다.");
        }
    }

    //    책 반납
    public final void returnBook() {
        if (!isAvailable) {
//            대여 중인 상태
            isAvailable = true;
            System.out.println("반납이 완료되었습니다.");
        } else {
            System.out.println("이미 반납이 되었습니다.");
        }
    }

    // 책 정보
    void displayInfo() {
        System.out.println("제목 : " + title + ", 저자 : " + author + ", 대여 가능 여부 : " + (isAvailable ? "대여가능" : "대여 중"));
    }
}

class Ebook extends Book { // There is no parameterless constructor available in 'chapter07.Book' : Book 클래스에 빈 생성자가 없으면 뜨는 에러
    private double fileSize;

    Ebook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    //    오버라이딩 - 책 정보 출력
    @Override
    void displayInfo() {
        super.displayInfo(); // 부모 클래스 메서드 호춯
        System.out.println("파일 크기 : " + fileSize + "MB");
    }

//        void returnBook() {} - 'returnBook()' in 'chapter07.Ebook' clashes with 'returnBook()' in 'chapter07.Book'; attempting to assign weaker access privileges ('package-private'); was 'public'

}

public class D_OOP_Practice {
    public static void main(String[] args) {
//        Book 객체 생성
        Book book1 = new Book("작별하지 않는다", "한강");
        book1.displayInfo();

//        책 대여
        book1.borrowBook();
        book1.borrowBook();

//        책 반납
        book1.returnBook();
        book1.returnBook();

//        Ebook 객체 생성
        Ebook ebook1 = new Ebook("달러구트 꿈 백화점", "이미에", 867.00);
        ebook1.displayInfo();

//        책 대여
        ebook1.borrowBook();

    }
}
