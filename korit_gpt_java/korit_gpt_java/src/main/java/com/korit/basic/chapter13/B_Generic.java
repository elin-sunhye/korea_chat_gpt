package com.korit.basic.chapter13;

/*
    === 제네릭 (Generic) ===
    : 디양한 데이터 타입을 처리할 수 있는 하나의 틀
*/

import java.util.ArrayList;
import java.util.List;

// 1) 타입 변수 : 무엇을 담을지 알려주는 표시
class Basket<T> {
    private T item;

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    static void printBasket(Basket<?> basket) {
        System.out.println("Fruit : " + basket.getItem());
    }
}

/*
    2) 제네릭 와일드 카드
    : 제네릭 타입을 불특정하게 지정할 때 사용
    : 주로 '상속 관계'에 있는 클래스 간의 유연한 타입 처리를 위해 사용
    - 모든 타입

    === 사용법 ===
    ? 기호를 사용하여 표기
*/

class Message<T> {
    private T message;

    T getMessage() {
        return message;
    }
}

public class B_Generic {
    public static void main(String[] args) {
        Basket<String> stringBasket = new Basket<>(); // 글자를 담는 바구니
        stringBasket.setItem("banana");
        System.out.println(stringBasket.getItem());

        Basket.printBasket(stringBasket);

        Basket<Integer> intBasket = new Basket<>(); // 숫자를 담는 바구니
        intBasket.setItem(43);
        System.out.println(intBasket.getItem());

        Basket.printBasket(intBasket);

//        업캐스팅 (List : interface / ArrayList : class)
        List<String> arrays = new ArrayList<>();

        Message<?> m1;
//        Message<String> m2;
        m1 = new Message<>();  // Object 타입의 Message 클래스 사용

//        Object 클래스는 모든 참조 타입의 최상위 클래스 : 상속 관계
        String s = (String) m1.getMessage();
        Boolean b = (Boolean) m1.getMessage();
        Character c = (Character) m1.getMessage();

/*
        == 일반 와일드 카드 ==
        ? : 어떤 타입이든 허용
*/
        List<?> list = new ArrayList<>();

/*      == 상한 제한 와일드 카드 ==
        <? extends Type>
        : 특정 타입 또는 그 하위 타입만 허용 <? extends Object>
*/
        List<? extends Number> list2 = new ArrayList<Integer>();
//        List<? extends Number> list2 = new ArrayList<Object>(); -> X

/*
        == 하한 제한 와일드 카드 ==
        <? super Type>
        : 특정 타입 ㄸ는 그 상위 타입만 허용
*/
        List<? super Integer> list3 = new ArrayList<Integer>();
        List<? super Integer> list4 = new ArrayList<Object>();

//        cf) Number : 정수 + 실수를 모두 포함하는 숫자 값
//        Integer : 정수
    }
}
