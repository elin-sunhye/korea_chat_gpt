package com.korit.basic.chapter08;

/*
    === 인터페이스(Interface) ===
    : 객체가 어떤 방식으로 동작해야하는지 정의하는 추상 타입
    - 추상 메서드와 상수만 포함된 특수한 클래스
    - 모든 메서드는 추상 메서드로 구성
    - 상수는 public static final 특성을 가짐
    >> 실제 구현은 인터페이스를 구현한 클래스에서 담당
    '상호작용'

    1. 인터페이스 특징
        1) 메서드
            : 모든 메서드는 기본적으로 public abstract로 선언
            >> 생략 가능
        2) 변수
            : 모든 변수는 기본적으로 public static final 상수
            >> 생략 가능

        +) 다중 구현 지원 (implements)
            : 한 클래스에서 여러 인터페이스를 동시에 구현 가능
        >> 객체의 행동을 정의하는 역할


    2. 추상 클레스 VS 인터페이스
        1) 추상 클래스
            - 공통적인 기능을 제공하는 '부분적 구현'
            - 구성 요소 : 추상 메서드, 구체 메서드, 필드, 생성자
            - 단일 상속 (extends)
            >> 기본 구현 제공하고 확장 가능

        2) 인터페이스
            - 클래스의 행동을 정의
            - 구성 요소 : 추상 메서드, 상수, 디폴트 메서드, 정적 메서드(오버라이딩 X)
            - 다중 구현 (implements)
            >> 갹체가 해야 할 동작(행위)을 정의

    3. 인테페이스 구현 방법
    interface 인터페이스명 {}
 */

interface PlayingCard {
    //    1. 멤버 선언
//    : 상수 (public static final 특성) - 선언과 동시에 초기화 필수
//    그냥 변수 선언 시 public static final 생략되어 있음
    public static final int SPADE = 4;
    public static int DIAMOND = 3;
    public final int HEART = 2;
    int CLOVER = 1;

    //    2. 메서드
//    : public abstract 특성
//    >> 모든 메서드가 추상 메서드
//    >> 해당 인터페이스 활용을 위해 모든 클래스에서 접근 가능 (public)
//    그냥 메서드 선언 시 public abstract 생략되어 있음
    public abstract String getCardNumber();

    String getCardKind();

    //    ==================
//    3. default 메서드
//    : 인터페이스에 새 기능을 추가하며서 기존 구현을 포함
//    >> 기본 구현 제공, 오버라이딩 가능
    default void defaultMethod() {
        System.out.println("default method");
    }

//    cf) 디폴트 멧드 - interface 내부에서 반드시 default 키워드 작성
//    : 작성 시 구현부가 존재할 수 없다는 오류 발생
//    void noDefault() {}

    //    4. 정적 메서드
//    : 인터페이스에서 직접 구현
//    >> 인터페이스 이름으로 직접 호출, 오버라이딩 불가 (객체 인스턴스 없이 사용 가능)
//    >> 인터페이스와 관련된 공통 동작(유틸리티) 메서드를 제공하기 위해 사용
    static void staticMethod() {
        System.out.println("static method");
    }
}

// === 인터페이스 구현 ===
class Card implements PlayingCard {
    private String cardNumber;
    private String cardKind;

    Card(String cardNumber, String cardKind) {
        this.cardNumber = cardNumber;
        this.cardKind = cardKind;
    }

    //    인터페이스 추상 메서드를 구현한 클래스 메서드는 public 지정
    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String getCardKind() {
        return cardKind;
    }

    //    default method 재정의
//    : 인터페이스 내이 디폴트 메서드 재정의 시 public 설정
    @Override
    public void defaultMethod() {
        System.out.println("재정의된 default method");
    }

//    인터페이스의 모든 메서드는 기본적으로 public 접근제어자를 가짐
//    : '어떤 동작을 외부에서 사용할 수 있음'을 보장
}

public class Interface01 {
    public static void main(String[] args) {
//        인터페스이스 추상 메서드 사용
        Card card = new Card("7", "HEART");

        System.out.println(card.getCardNumber());
        System.out.println(card.getCardKind());

//        재정의 (Overriding)
        card.defaultMethod(); // Card 클래스에서 재정의되니 디폴트 메세지

//        card.staticMethod(); - Error
        PlayingCard.staticMethod();

//        인터페이스의 필드(상수) 사용
        System.out.println(PlayingCard.CLOVER);
        System.out.println(PlayingCard.DIAMOND);
        System.out.println(PlayingCard.HEART);
        System.out.println(PlayingCard.SPADE);
    }
}
