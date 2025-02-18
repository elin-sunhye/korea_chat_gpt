package com.korit.basic.chapter07.orderApp;

/*
    Order class : 살제 주문 로직 구현
    특정 제품(product)과 수량(quantity)을 기반으로 주문 생성
    +) 총 가격(세금 포함)을 계산
 */
public class Order {
    private Product product;
    private int quantity;

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //    총 가격 계산 메서드
    double calculateTotalPrice() {
        double tax = product.calculateTax();
        double totalPrice = (product.getPrice() + tax) * quantity;
        return totalPrice;
    }

    //    주문 정보 반환 메서드
    @Override
    public String toString() {
        return "Order Detail [ " + product.getName() + " * " + "Quantity : " + quantity + " >> " + calculateTotalPrice() + " ]";
    }

}
