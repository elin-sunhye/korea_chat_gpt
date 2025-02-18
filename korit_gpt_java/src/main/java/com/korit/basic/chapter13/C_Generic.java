package com.korit.basic.chapter13;

/*
    === 재내릭 와일드 카드 정리 ===
    1. 일반 와일드 카드 (?)
    : 모든 타입 허용
    - List<?>

    2. 상한 제한 와일드 카드 (? extends Type)
    : 특정 타입 및 그 하위 클래스만 허용
    - List<? extends Number>

    3. 하한 제한 와일드 카드 (? super Type)
    : 큭정 타입 및 그 상위 클래스만 허용
    - List<? super Type>
*/

/*
    === 주문 관리 시스템 ===
    제품(Product) 할인(Discount) 정보 관리
    : 할인 정책 적용 시
    - 할인은 Product 또는 Product를 상속받는 하위 클래스에서만 적용
 */

import java.util.ArrayList;
import java.util.List;

// 1. 상위 클래스 : Product
class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

// 2. 하위 클래스 : Electronics, Furniture
class Electronics extends Product {

    public Electronics(String name, int price) {
        super(name, price);
    }
}

// 할인 정책
class DiscountPolicy {
    public static double applyDiscount(List<? extends Product> products, double discountRate) {
        double totalDiscount = 0.0;

        for (Product product : products) {
            double discount = product.getPrice() * discountRate;
            totalDiscount += discount;
            System.out.println(product.getName() + "Discount : " + discount + "won");
        }

        return totalDiscount;
    }
}

class Furniture extends Product {

    public Furniture(String name, int price) {
        super(name, price);
    }
}

public class C_Generic {
    public static void main(String[] args) {
        List<Electronics> electronics = new ArrayList<>();
        electronics.add(new Electronics("냉장고", 257));
        electronics.add(new Electronics("세탁기", 130));
        electronics.add(new Electronics("인덕션", 210));

        double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);

        List<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture("침대", 230));
        furnitureList.add(new Furniture("쇼파", 260));
        furnitureList.add(new Furniture("화장대", 80));

        double totalFurnitureList = DiscountPolicy.applyDiscount(furnitureList, 0.2);

        System.out.println("Total electronics discount : " + totalElectronics + "won");
        System.out.println("Total furniture discount : " + totalFurnitureList + "won");

        List<Product> products = new ArrayList<>();
    }
}
