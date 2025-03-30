package com.korit.basic.chapter06;

/*
    상속에서의 생성자
    : 상속 받은 클래스(자식)에서 생성자 호출 순서
    > 부모에서 자식 순서대로 진행

    자식 클래스 객체 생성 시 자식 클래스는 클래스의 생성자를 통해 객체 생성
    : 자식 클래스의 생성자 호출 시 '항상' 부모 클래스의 생성자가 호출
    > 사용자 정의 생성자 호출 필요 X
 */

/*
    Mammal 클래스
    1) 필드 : 이름(name), 숫자(number)
    2) 생성자 : 매개변수 X, 매개변수(String name) - 생성자 오버로딩
    3) 메서드 : 클래스 필드 정보를 출력(displayMammal)

 */
class Mammal {
    String name = "Parent";
    int number = 10;

//    Mammal(){}

    Mammal() {
        System.out.println("빈 부모 생성자 - 인스턴스 생성");
    }

    Mammal(String name) {
//        필드와 지역변수의 이름이 같을 경우 충돌방지를 위해 필드에 this. 키워드로 구분
        this.name = name; // Mammal 클래스로 생상되는 각 객체 (this)
    }

    void displayMammal() {
        System.out.println(name);
    }
}

/*
    Cat 클래스(자식) : Mammal 클래스(부모)를 상속 받음
    1) 필드 : 이름(name)
    2) 생성자 : 매개변수 X, 매개변수(String name) - 생성자 오버로딩
    3) 메서드 : 클래스 필드 정보를 출력(greet)
 */
class Cat extends Mammal {
    String name = "Child";

    //    Cat() {
//        super(); - 상속 받는 클래스의 기본 생성자에 반드시 포함
//    }
    Cat() {
//        super();
//        : 자식 클래스의 기본 생성자는 사용자 정의 생성자 호출이 없더라도 super() 부모 클래스 생정자 호출 키워드가 정의되어 있음(생략)
//        this();
//        : 사용자 정의 생성자에서 다른 생성자 호출 시 this() 사용 (생략X)
        System.out.println("빈 자식 생성사");
    }

    Cat(String name) {
//        super()는 부모 클래스의 생성자를 가져오는 키워드
//        : 부모 클래스 내에 정의 된 생성자 형태 그대로를 사용
        super(name);
//        this.name = name;
        System.out.println(" 자식 클래스가 생성 되었습니다.");
    }

    //    인스턴스 메서드
    void greet() {
//        해당 클래스가 가진 이스턴스 변수에 접근
//        this(생략 가능)
        System.out.println("자식 이름 : " + name);
        System.out.println("자식 이름 : " + this.name);

//        부모 클래스가 가진 인스턴스 변수에 접근
//        : super (생략 X)
//        super : 부모 클래스로 생성된 객체 그자체
//          - 부모 클래스 내의 필드와 메서드에 접근 .연산자 사용
//              super.필드명 / super.메서드명();
//        super() : 부모 클래스 내의 생성자 호출
        System.out.println("부모이름 : " + super.name);
    }
}

public class Inheritance02 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();

        Cat cat2 = new Cat("choco");
        System.out.println(cat2.name); // Child

        cat2.greet();

        System.out.println(cat2.number);


    }
}
