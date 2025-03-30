package com.korit.basic.chapter13;

/*
    === 빌더 (Builder) 패턴 ===
    : 객체 생성 방법 중 하나
    : 복잡한 객체를 단계별(구조적)로 만들때 사용
    - 필드(속성)가 많거나, 필수값과 선택값이 섞여 있을때 유용

    1. 빌더 패턴의 장단점
        1) 장점
            - 가독성 향상
            - 유연성 증가
            - 확정성 용이

        2) 단점
            - 구현 복잡성 증가(코드 양 ^)
            - 작은 객체에는 부적합

    2. 빌더 패턴 사용
    - 생성자가 너무 많아질 때
    - 코드가 복잡하고 읽기 어려울 때

    3. 빌더 패턴의 동작 원리
        1) 객체를 생성하는데 필요한 데이틀 저장하는 Builder 클래스 생성
        2) Builder 클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드 제공
        3) build() 메서드를 호출하여 객체 생성
*/

class Pizza {
    private final String menu;
    private final String size;

    //    선택
    private final boolean cheese;
    private final boolean mushrooms;
    private final boolean pepperoni;

//    public Pizza(String menu, String size, boolean cheese, boolean mushrooms, boolean pepperoni) {
//        this.menu = menu;
//        this.size = size;
//        this.cheese = cheese;
//        this.mushrooms = mushrooms;
//        this.pepperoni = pepperoni;
//    }

    //    === Builder 클래스 생성 ===
    public static class Builder {
        private final String menu;
        private final String size;

        //    선택 - 기본값 설정리 되어 있음 (추가하지 않으면 지정)

        private boolean cheese = false;
        private boolean mushrooms = false;
        private boolean pepperoni = false;

        public Builder(String menu, String size) {
//            필수값 설정
            this.menu = menu;
            this.size = size;
        }

        //        선택
        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }
}


public class E_Builder {
    public static void main(String[] args) {
//        Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", false, false,false);
        Pizza builderPizza = new Pizza.Builder("파인애플 피자", "L").build();
        Pizza pizza1 = new Pizza.Builder("치즈 피자", "L").addCheese().build();
        Pizza pizza2 = new Pizza.Builder("콤비네이션 피자", "L").addCheese().addMushrooms().addPepperoni().build();
    }
}
