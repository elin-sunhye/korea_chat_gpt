package com.korit.basic.chapter16;

/*
    === ENUM (열거형) ===
    : 서로 관련된 상수들의 집합을 표현하는 자료형
    - 서로 유기적인 관계성을 띄며, 자바의 클래스처럼 취급
    - 일반적으로 상수 선언에 사용되는 static final보다 더 간결하고 안전한 방식으로 정의
    - 특정 값들만 가질 수 있도록 제한

     Enum 기본 문법
    : enum Enum명  {}
    - Enum 명명의 대문자로 사직 UpperCamelcase 사용
    - 중괄호 내에 열거할 데이터를 ,로 구분하여 나열

    cf) class 사용법 : class Class명 {}
*/

// enum 내의 데이터는 final 특징을 살려 UPPER_SNAKE_CASE 사용
enum Fruits {APPLE, BANANA, ORANGE}

enum CoffeeSize {
    SMALL(200), MEDIUM(300), LARGE(400); // 생성자 호출
    private final int ml;

    CoffeeSize(int ml) {
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }
}

public class B_Enum {
    public static void main(String[] args) {
//        클래스의 static final 필드처럼 사용
//        - 각 상수는 정의된 enum 타입으로 간주
        Fruits apple = Fruits.APPLE;
        System.out.println(apple);

//        ENUM의 주요 메서드
//        - values() : 열거형의 모든 값을 배열로 반환
        System.out.println(Fruits.values());

//        cf) Enum  순환
        for (Fruits fruit : Fruits.values()) {
            System.out.println(fruit);
        }

//        - name() : Enum 상수의 이름을 문자열로 반환
        String appleNm = Fruits.APPLE.name();
        System.out.println(appleNm);

//        - ordinal() : Enum 상수의 순서 반환 (0부터 시작)
//        - valueOf(String name) : 문자열로 Enum 상수 반환
//          >> 잘못된 문자열 전달 시 IllegalArgumentException 발생
//        Fruits orangeFruit = Fruits.valueOf("Orange"); - IllegalArgumentException
        Fruits orangeFruit = Fruits.valueOf("ORANGE");
        System.out.println(orangeFruit.ordinal());

//       === CoffeeSize 자료형 사용 ===
        System.out.println("=== CoffeeSize 자료형 사용 ===");
        CoffeeSize size = CoffeeSize.MEDIUM;
        System.out.println("Selected size : " + size + ", Volume : " + size.getMl() + "ml");
    }
}
