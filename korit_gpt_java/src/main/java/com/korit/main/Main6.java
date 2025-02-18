package com.korit.main;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Console;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

@AllArgsConstructor
class Authority<T> implements Supplier<T> {
    private T role;

    @Override
    public T get() {
        return role;
    }
}
public class Main6 {
    public static void main(String[] args) {
//        === Thread(Main 메소드의 역할) ===
        Runnable runnable;
        List<Runnable> programs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            Runnable r = () -> System.out.println("프로그램" + (finalI + 1));
            programs.add(r);
//            programs.add(() -> System.out.println("프로그램" + (finalI + 1)));
//            () -> System.out.println("프로그램" + (finalI + 1)) -> Runnable
        }



//        === 매개변수로 값을 받아서 해당 값을 처리 (처리한 결과 return X) ===
        Consumer<String> consumer;
        programs.forEach(Runnable::run);

        BiConsumer<Integer, String> biConsumer;
        Map<String, Object> userMap = Map.of("useName", "admin", "password", "1234");
        /*
            {
                "userName":"admin", Map 에서 한쌍 == entry 한줄한줄을 entry라고 한다
                "password":"1234"
            }
         */
        Set<Map.Entry<String, Object>> entries = userMap.entrySet();
//        [password=1234, useName=admin]
        System.out.println("entries" + entries);

        for (Map.Entry<String, Object> entry : entries) {
            entry.getKey();
            entry.getValue();
        }
        userMap.forEach((key, value) -> System.out.println(key + ":" + value));



//        === 매개변수로 값을 받지 않고 처리한 데이터를 return ===
        Supplier<String> supplier;
        Authority<String> authority = new Authority<>("ROLE-ADMIN");
        String role = authority.get();



//        === 매개변수로 값을 받아서 처리한 데이터를 return ===
        Function<String, String> function;
        Function<Integer, Integer> addFunction = num -> num * 10;
        Integer result = addFunction.apply(100);

        BiFunction<Integer, Integer, String> biFunction;
        BiFunction<Integer, Integer, Integer> addBiFUnction = (num1, num2) -> num1 + num2;
        Integer result2 = addBiFUnction.apply(100, 200);



//        === return type이 무조건 boolean ===
        Predicate<String> predicate;
        List<Integer> nums = List.of(1,2,3,4,5);
        List<Integer> evenNums = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("evenNums" + evenNums);

        BiPredicate<Integer, Integer> biPredicate;




//        === 매개변수 타입 == 리턴타입, function을 상속받고 있다 ===
        UnaryOperator<Integer> unaryOperator;
        BinaryOperator<Double> binaryOperator;

//        cf) 추상화의 장점 : 동일한 인터페이스로 묶을수 있따 (캡슐화)
    }
}