package com.korit.basic.chapter13;

/*
    === Singleton 패턴 ===
    : 소프트웨어 설계 패턴 중 하나
    >> 클래스의 인스턴스가 하나만 생성 되도록 보장
    >> 해당 클래스의 인스턴스의 전역적 접근을 제공하지만 일관된 상태를 유지

    1. 싱글톤 페턴 사용 목적
        1) 객체의 유일성을 보장
        2) 자원 절약

    2. 싱글톤 패턴의 장단점
        1) 장점
            - 자원 중복 생성 방지
            - 메모리 사용 최적화
            - 전역 상태 공유 + 통제된 접근

        2) 단점
            - 전역 상태를 관리하고, 다른 클래스에 영향 (결합의 가능성)
            - 테스트가 어럽다
*/

class Singleton {
    //    static filed
//    : 클래스 타입 그 자체를 가지는 필드
    private static Singleton instance;

    //    생성자를 private 선언 : 외부에서 직접적인 인스턴스화 불가
    private Singleton() {
    }

    //    전역 접근성을 제공하는 메서드 정의 (인스턴스화 담당)
//    인스턴스화 한번만! 그래서 조건문 구현
    public static Singleton getInstance() {
        if (instance == null) { // static 필드에 아무런 값이 없다면 (한번도 인스턴스화 X)
            instance = new Singleton();
        }

        return instance;
    }
}

// 교장 선생님 클래스
class SchoolPrinciple {
    //    유일한 객체를 저장할 변수
    private static SchoolPrinciple instance;

    //    1. 생성자를 private으로 만들어 다른 곳에서 객체 생성이 불가하도록 샐정
    private SchoolPrinciple() {
        System.out.println("principle Filed");
    }

    //    2. getInstance() 메서드를 통해 객체를 제공
    public static SchoolPrinciple getInstance() {
        if (instance == null) { // 객체가 없으면 새로 생성Z
            instance = new SchoolPrinciple();
        }
        return instance; // 객체를 반환
    }

    public void announce() {
        System.out.println("공부 열심히 하고 밥 잘 먹고 일찍 자고 일찍 일어나세요.");
    }
}

public class D_Singleton {
    public static void main(String[] args) {
        SchoolPrinciple principle1 = SchoolPrinciple.getInstance();
        SchoolPrinciple principle2 = SchoolPrinciple.getInstance();

        System.out.println(principle1);
        System.out.println(principle2);
        System.out.println(principle1 == principle2);

        principle1.announce();
    }
}
