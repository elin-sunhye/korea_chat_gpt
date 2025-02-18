package com.korit.basic.chapter07.orderApp;

/*
    Electronics class (자식 클래스)
    +) 전자 제품은 특별 세율 적용 : 15%
 */
public class Electronics extends Product {
//    private String name;
//    private int price;

    Electronics(String name, int price) {
        super(name, price);
    }

//    int getPrice() {
//        return price;
//    }

    @Override
    double calculateTax() {
        return getPrice() * 0.5; // super가 아닌 this가 생략되어있다.
    }
}
