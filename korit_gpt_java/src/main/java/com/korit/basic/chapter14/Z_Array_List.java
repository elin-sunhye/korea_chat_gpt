package com.korit.basic.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z_Array_List {
    public static void main(String[] args) {
        /*
        === 배열(Array) VS 리스트(List) ===
        1. 배열(Array)
        : 여러 데이트롤 하나의 object로 관리하기 위한 자료 구조
        : 시작이 0부터 시작하는 저장 순서를 가지며, 해당 index 번호를 통해 데이터에 접근
        : 연속된 메모리 공간에 저장
        - 배열은 정의와 동시에 길이를 지정해야하며, 길이 변경 불가(고정된 길이값)

        2. 리스트(List)
        : 순서가 있는 element(요소)의 모임
        : ArrayList, LinkedList 등 존재
        : Array의 index 번호가 데이터의 식별자 역할 VS List의 index 번호는 데이터의 저장 위치만 확인하는 의미
        : 불연속적 메모리 공간을 차지
        : Array와 달리 동적, 배열의 크기가 정해져 있지 않음, 길이 변경 가능
*/
//        ==============================================================================================================
/*
        +) List<> 타입 변수에는 List.of()와 ArrayList로 생성된 불변 리스트, 가변 리스트 모두 할당 가능
        List.of() 메서드
        : 읽기 전용(불변) 리스트를 생성하는데 사용
        - 추가, 수정, 변경 불가
        - null 값 불포함
*/

        List<String> immutableList = List.of("apple", "banana", "cherry", "orange");
//        immutableList.add("melon");
//        immutableList.remove("melon");
//        immutableList.set(0, "melon");

        List<String> dynamicList = new ArrayList<>();
        dynamicList.add("grape");
        dynamicList.add("mango");
        System.out.println(dynamicList);
        dynamicList.remove("orange");
        System.out.println(dynamicList);

        List<String> changeList = new ArrayList<>(immutableList);
        changeList.add("strawberry");
        System.out.println(changeList);

        List<String> changeList2 = new ArrayList<>();
        changeList2 = List.of("과일1", "과일2");
//        changeList2.add("과일3");

//        +) Array.asList()
//        : 배열을 리스트로 변환하는 방식
        List<String> asList = Arrays.asList("사과", "바나나", "키위");
//        asList.add("수박");

/*
        new ArrayList<>() VS Arrays.asList() VS List.of()
        1. 구현 방식
        생성자 방식 VS Arrays 클래스의 asList 메서드 VS List 인터페이스 of 메서드

        2. 원소 추가 삭제 (add(), remove())
        O VS X VS X

        3. 원소 수정 (set())
        O VS O VS X

        +) Arrays.asList()가 반환하는 리스트는 가짜 ArrayList
            - Arrays 클래스 내부에 구현된 별개의 ArrayList(컬렉션 프레임워크 X)
*/
    }
}
