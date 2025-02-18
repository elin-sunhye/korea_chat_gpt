package com.korit.basic.chapter14.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
    === 람다 표현식 (Lambda Expression) ===
    : 자바 8에서도입되 함수형 프로그래밍 표현식
    >> 익명 클래스를 간결하게 표현

    1. 람다 사용법
    (params) -> {실행 코드}

    2. 예시
        1) params, 반환값이 모두 없는 람다
        () -> System.out.println("");

        2) params가 하나인 람다
        X -> X *Y;

        3) params가 두개 이상인 람다
        (a, b) -> a + b;

        4) 실행문이 두줄 이상인 람다
        : 두줄 이상인 경우 return 키워드를 사용하여 값을 반환
        () -> {
            System.out.println("");
            return "";
        }
        ||
        (x, y) -> {
            int result = x + y;

            System.out.println("Sum : " + result);
            return result;
        }
 */
public class B_Lambda {
    public static void main(String[] args) {
//        1. (int x, int y) -> x + y;
//        2. () -> System.out.println("");
//        3. (String s) -> {
//               System.out.println(s);
//               return s;
//           };

//        === 람다식 사용 예시 ===
//        주로 @FunctionalInterface(하나의 추상 메서드만 가지는 인터페이스)와 함께 사용
        List<String> list = Arrays.asList("apple", "orange", "banana");

/*
        .sort() : List를 정렬하는 메서드
        a.compareTo(b) : a와 b 두개이 값을 비교하여 같을 경우 0
        +) 포함되어 있을 경우
            오름차순 정렬 : 양수, 내림차순 정렬 : 음수
*/
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);

/*
        === 함수형 인터페이스 ===
        1) Predicate<T> : boolean test(T t)
        - 주어진 조건을 테스트
        - Stream APi와 결합되어 쓰임

        2) Function<T, R> : R apply(T t)
        - 입력값을 다른 타입으로 변환

        3) Consumer(T) : void accept(T t)
        - 입력값을 소비

        4) Supplier<T> : T get()
        - 값을 반환
*/
        Function<String, Integer> fx = s -> s.length();
        Integer result1 = fx.apply("abcde");
        System.out.println(result1);

        Function<String, String> fx2 = s -> s.toUpperCase();
        String result2 = fx2.apply("abcde");
        System.out.println(result2);

        Function<String, Integer> fx3 = s -> Integer.parseInt(s);
        Integer fx3Result = fx3.apply("10");
        System.out.println(fx3Result);

        Integer data = fx3
                .andThen(d -> d + 100)
                .apply("10");
        System.out.println(data);

        Predicate<Integer> even = n -> n % 2 == 0;
        System.out.println(even.test(10));
        System.out.println(even.test(11));

/*
        === 메서드 참조 ===
        : 함수형 인터페이스를 간결하게 표현
        - :: 연산자를 사용하여 기존 메서드 참조
*/
        List<String> names = Arrays.asList("이승아", "이도경", "김명진");
        System.out.println("=== 일반 람다식 ===");
        names.forEach(name -> System.out.println(name));
        System.out.println("=== 메서드 참조 ===");
        names.forEach(System.out::println);
    }
}
