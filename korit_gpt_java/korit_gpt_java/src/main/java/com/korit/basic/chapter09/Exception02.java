package com.korit.basic.chapter09;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    === throws 키워드 ===
    : 메서드 선언부에 위치
    : 호출자에게 예외 처리를 위임
    - 체크(컴파일) 예외 : 필수 / 언체크(런타임) 예외 : 선택
    - (접근제어자) 반환타입 메서드명() throws ExceptionType {}
*/

class InvalidUserException extends Exception {
    InvalidUserException(String message) {
        super(message);
    }
}

/*
    cf) throw 키워드
    - 메서드 내부에 위치
    - 예외를 발생 시킴
    -throw new ExceptionTYpe("에러메시지")
*/

/*
    Throwable : 예외(Exception) + 오류(Error)

    === 사용자 정의 예외 클래스 ===
    : 자바의 Exception 클래스를 상속받는 자식 클래스
 */
class CustomException2 extends Exception {
    //    생성자
    CustomException2(String message) {
//        부모 클래스(Exception)의 생성자 호출
        super(message);
    }
}

public class Exception02 {
    //    1) 단일 예외 던지기
//    메서드 선언부에서 해당 메소드가 던질 수 있는 예외를 명시하는 키워드
//    : 호출자에게 예외 처리를 위임
    static void login(String userName, String password) throws InvalidUserException {
        if (!"admin".equals(userName)) {
            throw new InvalidUserException("사용자 이름이 잘못 되었습니다.");
        }
    }

    //    2) 다중 예외 던지기
    static void exceptions(int num) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        if (num == 1) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        } else if (num == 2) {
            throw new ArrayIndexOutOfBoundsException("배열 인덱스를 초과하였습니다.");

        }
    }

    public static void main(String[] args) {
//        === 사용자 정의 예외 사용 ===
//        throw new CustomException2("예외 처리되지 않는 예외");
//        : 사용자 정의 예외를 방생시키는 thow의 경우 예외처리 구문 내에 사용되지 않으면 (컴파일)예외 발생
        try {
            throw new CustomException2("사용자 정의 예외가 발생");
//            : 사용자 정의 예외가 발생 - (런타임) 예외
        } catch (CustomException2 e) {
//            발생된 예외를 catch 블록에서 처리
            System.out.println(e.getMessage());
        }

        System.out.println("========================");

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("정수를 입력하세요.");
            int number = scanner.nextInt();
            System.out.println("입력하신 숫자는 " + number + " 입니다.");
        } catch (InputMismatchException e) {
//            catch 블럭의 예외객체인 'e'
//            : 주로 객체변수는 Exception의 철자를 사용하여 'e'로 명시
            System.out.println("정수가 아닌 다른 타입이 작성되었습니다.");
        } finally {
            scanner.close();
        }

        try {
            login("admin", "password");
//            throws 키워즈는 해당 멧드에서 발생할 수 있는 가능성을 처리하는 키워드
//            : 처리는 해당 메서드의 호출부에서 담당
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("========================");
//        exceptions(1);
        try {
            System.out.println("다중 예외 던지기");
            exceptions(0);
        } catch (ArithmeticException e) {
            System.out.println("예외처리 1 : " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("예외처리 2 : " + e.getMessage());
        }
        System.out.println("정상적인 코드");

    }
}
