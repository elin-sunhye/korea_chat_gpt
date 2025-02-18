package com.korit.basic.chapter07.orderApp;

/*
     Main class
     : 주문 시스템의 실행 진입점
     - 제품 생성, 주문 생성, 주문 결과 출력 ...
 */
public class Main {
    public static void main(String[] args) {
//        제품 생성
        Product laptop = new Electronics("Laptop", 5000);
        Product apple = new Food("Food", 6000);

//        주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);

        System.out.println(order1); // 5750
        System.out.println(order2); // 60000

//        toString()
//        : '클래스명@해당객체의주소값'이 문자열로 출력
//        >> 객체를 문자열로 표현할 때 사용
//        >> 모든 클래스의 최상위 클래스인 Object 클래스에 정의
    }
}
