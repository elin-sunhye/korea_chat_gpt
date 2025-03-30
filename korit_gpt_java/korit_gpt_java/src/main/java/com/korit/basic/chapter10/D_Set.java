package com.korit.basic.chapter10;

/*
    === Set 인터페이스 ===
    중복X, 순서X
    : 중복된 요소를 포함하지 않는 객체의 집합
    : 객체의 저장 순서를 저장하지 않음 (삽입 순서 유지 X)
    >> null 요소 포함 가능 ["apple", null, "orange"]

    cf) List 인터페이스
    중복O, 순서O, null 요소 포함 가능
    ["apple", null, "orange"] -> 순서대로 반환
    
    === Set 컬렉션 종류 (구현체) ===
    1. HashSet
    : 가장 많이 사용되는 구현체 >> 빠른 데이터 접근과 삽입 지원
    - 정렬 또는 순서 보장 X
    
    2. LinkedHashSet
    : HashSet 에서 순서를 추가한 구현체
    - 중복 X, 순서 O (인덱스 번호로 구분 X)
    
    3. TreeSet
    : 데이터가 자동 정렬(또는 사용자 정의 정렬), 중복 제거와 정렬된 순서 유지가 필요한 구현체
    - 중복 X, 순서 O
 */

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {
//        === Set 컬렌션의 주요 메서드 ===
//        : add(), remove(), contains(), size(), isEmpty()

//        set 컬렉션 선언 방법
//        Set<E> set명 = new Set컬렉션종류<>();
        Set<String> exampleSet = new HashSet<>();
        exampleSet.add("Java");
        exampleSet.add("Python");
        exampleSet.add("C++");
        exampleSet.add("JavaScript");

        System.out.println("배열 : " + exampleSet); // [Java, C++, JavaScript, Python]

        exampleSet.remove("Java"); // 제거하고자하는 데이터 자체를 작성
        System.out.println("제거 : " + exampleSet); // [C++, JavaScript, Python]

        System.out.println("사이즈 : " + exampleSet.size());

//        중복된 데이터는 추가할 수 없음
        exampleSet.add("Python");
        System.out.println("중복 데이터 추가 : " + exampleSet); // [C++, JavaScript, Python]

        System.out.println("포함 여부 확인 : " + exampleSet.contains("JavaScript"));
        System.out.println("포함 여부 확인 : " + exampleSet.contains("Java"));

        System.out.println("비워져있는지 확인 : " + exampleSet.isEmpty());
        exampleSet.clear();
        System.out.println(".clear() 후 비워져있는지 확인 : " + exampleSet.isEmpty());
    }
}
