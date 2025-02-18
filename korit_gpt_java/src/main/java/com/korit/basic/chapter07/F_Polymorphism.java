package com.korit.basic.chapter07;

/*
     === 다형성 ===
     : 많은 형태를 가질 수 있는 특성
     >> 하나의 객체가 여러 타입의 인스턴스(객체)로 취급될 수 있는 특성
     >> 상속 + 메서드 오버리이딩 + 클래스 타입 변환

     cf) instanceof 연산자
     : 참조변수값 instanceof 타입(클래스명)
     >> 해당 객체가 특정 클레스의 인스턴스인지 또는 그 클래스를 상속 받은 자식 클래스이 인스턴스인지 확인
     >> boolean 값으로 반환
     자식 instanceof 부모 : 자식이 부모가 될수가 잇냐
 */

// Vehicle : 운송수단, 탈 것
class Vehicle {
    void display() {
        System.out.println("..Vehicle..");
    }
}

class Bus extends Vehicle {
    @Override
    void display() {
        System.out.println("..Bus..");
    }
}

class Subway extends Vehicle {
    void display() {
        System.out.println("..Subway..");
    }
}

public class F_Polymorphism {
    public static void main(String[] args) {
//        다형성 적용
//        : 부모 클래스 타입의 참조 변수로 자식 클래스 객체를 참조
        Vehicle myVehicle = new Vehicle();
        Bus myBus = new Bus();
        Subway mySubway = new Subway();

        if (myBus instanceof Vehicle) {
//            myBus 객체가 Vehicle의 인스턴스 || Vehicle을 상속받은 인스턴스의 경우
            myBus.display();
        }

        if (myVehicle instanceof Bus) {
            System.out.println("bus!!!");
        } else {
            System.out.println("No Bus");
        }

//        instanceof 연산자 계산식에서 true 값일 경우
//        : 해당 클래스 타입으로 형 변환 가능
    }
}
