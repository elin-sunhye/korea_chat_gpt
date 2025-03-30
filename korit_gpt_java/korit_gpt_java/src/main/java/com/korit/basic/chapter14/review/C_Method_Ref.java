package com.korit.basic.chapter14.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/*
   === 메서드 참조 ===
 */

// 1. 정적 메서드 참조
class StaticMethod {
    static void printUppercase(String str) {
        System.out.println(str.toUpperCase());
    }
}

// 2. 인스턴스 참조 메서드
class InstanceMethod {
    void printLowercase(String str) {
        System.out.println(str.toLowerCase());
    }
}

// 3. 특정 객체의 인스턴스 참조
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

// 4. 생성자 참조
class Human {
    private String name;

    public Human() {
        this.name = "Unknown";
    }

    public String getName() {
        return name;
    }
}

public class C_Method_Ref {
    public static void main(String[] args) {
/*
        1. 정적 메서드 참조
        클래스명::정적메서드명
 */
        List<String> fruits = Arrays.asList("apple", "mango", "banana");
        fruits.forEach(StaticMethod::printUppercase);

/*
        2. 인스턴스 참조 메서드
        인스턴스명::인스턴스메서드명
 */
        InstanceMethod instanceMethod = new InstanceMethod();
        List<String> fruits2 = Arrays.asList("APPLE", "MANGO", "BANANA");
        fruits2.forEach(instanceMethod::printLowercase);

/*
        3. 특정 객체의 인스턴스 참조
        cf) BiFunction : 두개의 인자를 받고 한개의 객체를 리턴시키는 함수형 인터페이스
        BiFunction<T, U, R>
 */
        Calculator calculator = new Calculator();
        BiFunction<Integer, Integer, Integer> addition = calculator::add;
        int result = addition.apply(5, 3);
        int result2 = addition.apply(15, 13);
        System.out.println(result);
        System.out.println(result2);

/*
        4. 생성자 참조
 */
        Supplier<Human> humanSupplier = Human::new;
//        new Human();
        Human human1 = humanSupplier.get();
        Human human2 = humanSupplier.get();
        Human human3 = humanSupplier.get();
        System.out.println(human1.getName());
        System.out.println(human2.getName());
        System.out.println(human3.getName());

    }
}
