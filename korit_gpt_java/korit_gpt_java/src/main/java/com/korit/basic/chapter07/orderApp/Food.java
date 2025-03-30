package com.korit.basic.chapter07.orderApp;

/*
    Food class
    +) 식품은 세금 면제
 */
public class Food extends Product {
    Food(String name, int price) {
        super(name, price);
    }

    @Override
    double calculateTax() {
        return 0; // super가 아닌 this가 생략되어있다.
    }
}
