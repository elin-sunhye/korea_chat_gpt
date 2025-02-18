package com.korit.basic.chapter07.practiceApp;

class Parent {
    void kind() {
        System.out.println("과일입니다.");
    }
}

class Child1 extends Parent {
    @Override
    void kind() {
        System.out.println("BANANA");
    }
}

class Child2 extends Parent {
    @Override
    void kind() {
        System.out.println("APPLE");
    }
}

class Child3 extends Parent {

    void kind(String name) {
        System.out.println(name);
    }
}

public class Entity {
    void handleKind(Parent parent) {
        parent.kind();
    }

}
