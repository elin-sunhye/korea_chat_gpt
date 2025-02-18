package com.korit.basic.chapter10.practice2.entity;
/*
    === 아이템 ===
    Item 추상 클래스 : item들이 공통으로 가지는 필드 생성 (고유 아이디, 이름, 가격, 수량)
    생성자로 초기화
    getter 생성 (필드에 데이터를 넘겨주면 그 데이터를 다시 꺼낼 수 있도록)
    추상 메서드 카테고리 반환 메서스 생성 (카테고리 반환를 추상 메서드로 결정한 이유는 각 item마다 반환되는 카테고리가 다르니까)
    일반 메서드 생성하여 필드 값 출력

    각 item들을 정해서 클래스를 만들어서 Item 추상 클래스의 추상 메서드를 재정의(재구현) extends
    그리고 각 item들만의 고유 필드 생성 (전자: 브랜드 , 유효기간 / 가구: 재질, 사이즈)
    생성자로 초기화 (부모 필드도 같이 초기화)
    getter 생성 (필드에 데이터를 넘겨주면 그 데이터를 다시 꺼낼 수 있도록)
    추상메서드로 각 아이템의 카테고리 반환
    일반 메서드 오버라이드는 선택이지만, 각 아이템만의 고유 필드 데이더와 같이 출력되게 오버라이드 했음


    === 아이템 재고 현황 ===
    ItemRepository 인터페이스 생성
    재고현황에 공통으로 필요한 메서드 생성
    ** 이 때 Item의 필드로 검색 기능은 Item 추상클래스에서 id를 가져와야한다. (== 타입이 Item 이다!)
    재고 아이템들을 인덱스 값으로 찾지말고, 재고 객체 그자체로 찾기 위해 Set<> = HashSet사용 (순서x 정렬 x, 중복x)
*/

public abstract class Item {
    private String id;
    private String name;
    private int price;
    private int quantity;

    public Item(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getCategory(); // 카테고리 반환

    @Override
    public String toString() {
        return "ID ; " + id + ", Name ; " + name + ", Price : " + price + ", Quantity : " + quantity;
    }
}
