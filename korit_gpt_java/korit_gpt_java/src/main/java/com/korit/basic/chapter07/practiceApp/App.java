package com.korit.basic.chapter07.practiceApp;

import java.util.ArrayList;

/*
    App class
     Entity의 객체 (Parent, Child1,2)를 활용하는 시스템 구현

     과일 관리 시스템
 */
public class App {
    public static void main(String[] args) {
        Entity entity = new Entity();

        ArrayList<Parent> fruits = new ArrayList<>();
        fruits.add(new Child1());
        fruits.add(new Child2());

        for (Parent fruit : fruits) {
            entity.handleKind(fruit);
        }

        Child3 child3 = new Child3();
        child3.kind("바니니");
    }
}
