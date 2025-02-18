package com.korit.basic.chapter07;

/*
     === 자바에서의 형 변환 ===
     1) 자료형 변환 : 변수 & 자료형에서의 자동 형 변환(묵시적), 강제 형 변환(명시적)
     2) 클래스 타입 변환
        - 자동 타입 변환(Upcasting), 강제 타입 변환(Downcasting)
        : 자료형 변환보다 가능한 범위가 좁음
            >> 상속 관계에 있는 클래스 사이에서만 변환 가능
 */

class Parent {
    void displayInfo() {
        System.out.println("parent class");
    }
}

class ChildClass extends Parent {
    @Override
    void displayInfo() {
        System.out.println("Child class");
    }

    void childMethod() {
        System.out.println("child class has method");
    }
}

public class E_Class_Type {
    public static void main(String[] args) {
//        === 자동 타입 변환(Upcasting) ===
//        : 자식 객체를 부모 클래스 타입으로 변환
//        >> 직접 명시 X, 자동으로 타입 변환이 일어남

//        1. 자식 객체를 생성하면서 즉시 부모 타입으로 변화하여 저장
//          부모 클래스 객채 변수 = new 자식 클래스();
        Parent childObject = new ChildClass();
        childObject.displayInfo();
//        childObject.childMethod(); - Cannot resolve method 'childMethod' in 'Parent' : 자식 클래스이 고유 메서드는 호출 불가
//        >> 자동 형 변환의 경유 객체는 보전되면서 사용은 부모 객체처럼 사용
//          : 두 클래스 간의 공통된 특성이 아닌 경우 자식만의 기능은 사용 X

//        2. 이미 생성된 객체를 부모 타입으로 변환
        ChildClass childObject2 = new ChildClass();

//        부모 클래스 객체 변수 = 자식객체 변수;
        Parent parentObject = childObject2; // 업캐스팅
        parentObject.displayInfo();
//        parentObject.childMethod(); - Cannot resolve method 'childMethod' in 'Parent'

//        === 강제 타입 변환(Downcasting) ===
//        : 부모 클래스 타입으로 변환된 객체를 다시 자식 클래스 타입으로 변환
//        >> 자식 클래스에만 정의된 멤버에 접근 가능

//        자식타입 객체변수 = (자식타입) 부모객체;
        ChildClass childClass = (ChildClass) parentObject; // 다운캐스팅
        childClass.childMethod();
        childClass.childMethod();

//        cf) 클래스 타입 변환 시 주의점
//        반드시 상속 관계와 객체의 실제 타입을 확인
//        : 잘못된 캐스팅은 Exception 발생
    }
}
