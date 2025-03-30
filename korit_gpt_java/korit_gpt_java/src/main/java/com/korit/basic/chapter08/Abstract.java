package com.korit.basic.chapter08;

/*
    === 추상화(Abstract) ===
    1. 추상 클래스 정의
    : 미완성 설계도, 완전하지 않은 클래스
    >> 자체로 인스턴스 생성 불가
    >> 다른 클래스가 상속 받아 완성해야만 사용 가능

    2. 추상 클래스 특징
    1) 클래스 자체로 이스턴스 생성 불가
    2) 하나 이상의 추상 메서드를 포함
    3) 확장성 제공을 위해 사용
        - 자식 클래스들이 공통된 기능 공유 + 공유 기능 구현하도록 강제
    4) 다중 상속 불가 - 하나의 extends만 가능
    EX) '라이거' : 사자(lion) + 호랑이(tiger)
    abstract class Lion {
        abstract void mane(); // 갈기
    }

    abstract class Tiger {
        abstract void stripe(); // 줄무늬
    }

    class Liger extends Lion extends tiger { - 다중 상속 불가
        void mane() {}
        void stripe() {} - 해당 메서드를 상속 받을 수 없음
    }

    +) 메서드 오버라이딩 VS 추상 메서드
    - 추상 메서드  : 반드시 자식 클래스에서 오버라이딩 해야함
    - 일반 메서드 : 필요에 따라 오버라이딩 가능

    3. 추상 클래스 구현 방법
    : 클래스 선언 앞에 'abstract' 키워드 사용

    cf) 추상 메서드
    : 메서드의 선언부만 존재, 구현부가 없는 메서드
    >> 자식 클래스에서 해당 메서드를 반드시 구현하도록 강제하는 역할
    >> abstract 키워드 + 구현부 {} 대신 세미콜론 ;을 사용하여 선언 마침

    cf) 메서드의 구성 : 선언부 + 구현부
    (접근제어자) 반환타입 메서드명(매개변수...) { 메서드의 기능 동작}
*/

// 4. 추상 클래스 예시
abstract class Human {
    abstract void work(); // 추상 메서드 - 구현부 {} 없음
}

class Police extends Human {
    //    추상 메서드
    @Override
    void work() {
        System.out.println("경찰은 치안유지 업무를 담당합니다.");
    }
}

class Student extends Human {
    //    추상 메서드 구현
    @Override
    void work() {
        System.out.println("학생은 공부를 합니다.");
    }
}

// 5. 추상 클래스 예시 2
abstract class Animal {
    abstract void makeSound();

    //    구체적인 메서드(일반 메서드 - 선언부 구현부)
    void eat() {
        System.out.println("동물은 먹이를 먹습니다.");
    }
}

class Dog extends Animal {
    //    추상 메서드 구현
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }

    @Override
    void eat() {
        System.out.println("개껌 냠냠");
    }
}

class Cat extends Animal {
    //    추상 메서드 구현
    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}


public class Abstract {
    public static void main(String[] args) {
//        Animal animal = new Animal(); - 'Animal' is abstract; cannot be instantiated

        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat(); // 오버라이딩

        cat.makeSound();
        cat.eat(); // 부모 클래스에서 정의된 기능
    }
}
