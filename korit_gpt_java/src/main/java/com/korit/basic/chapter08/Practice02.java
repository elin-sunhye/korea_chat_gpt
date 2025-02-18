package com.korit.basic.chapter08;

/*
    === 인터페이스 ===
    Fruit 인터페이스 정의
    - color : 추상 메서드
    - describe : 디폴트 메서드
    - printType : 정적 메서드
 */

interface Fruit {
    String color();

    default void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 과일의 모양은 동그랗다");
    }

    static void printType() {
        System.out.println("Fruit Type");
    }
}

class Apple implements Fruit {

    @Override
    public String color() {
        return "red";
    }

}

class Orange implements Fruit {
    @Override
    public String color() {
        return "orange";
    }
}

class Banana implements Fruit {
    @Override
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("길쭉하다" + "색은 " + color());
    }

    void ss() {
        System.out.println("바나나 메서드");
    }
}

// 또 다른 인터페이스
interface TropicalFruit extends Fruit {
//    extends (상속 - 확장하다)
//    : 클래스 간, 인터페이스 간에 가능

    //    cf) implement (구현 - 구현하다)
//    : 인터페이스를 클래스로 구현
    default void tropicalFeature() {
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {
    public String color() {
        return "golden";
    }

    @Override
    public void describe() {
        System.out.println("색은 " + color() + ", 타원형 이다");
    }

}

public class Practice02 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

//        === 다형성 예제 ===
//        mango가 Fruit로 형 변환 (업캐스팅)
        Fruit[] fruits = {apple, orange, banana, mango};

        for (Fruit fruit : fruits) {
            fruit.describe();

            if (fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit; // 다운 캐스팅
                tropicalFruit.tropicalFeature();
            }
        }

//        cf) A instanceof B 연산자
//        : A 객체가 B 클래스타입(종류)이 될수 있는지 확인해줘
//        : boolean으로 반환
        class 동물 {
        }
        class 고양이 extends 동물 {
        }
        class 강아지 extends 동물 {
        }

        동물 나비 = new 고양이();
        동물 멍멍이 = new 강아지();
        if (나비 instanceof 고양이 && 나비 instanceof 동물) {
            // o
        }
        if (멍멍이 instanceof 고양이) {
            // x
        }

        if (mango instanceof Fruit) {
            Fruit mangoAsFruit = (Fruit) mango;
            mangoAsFruit.describe();
        }

        if (banana instanceof TropicalFruit) {
//            TropicalFruit bananaAsTropicalFruit = (TropicalFruit) banana;
//            bananaAsTropicalFruit.tropicalFeature();
        } else {
            System.out.println("바나나는 열대 과일이 아닙니다.");
        }

        if (banana instanceof Banana) {
            Banana banana2 = (Banana) banana;
            banana2.ss();
        }

        Fruit.printType();
    }
}
