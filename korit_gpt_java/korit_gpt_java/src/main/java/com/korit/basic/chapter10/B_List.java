package com.korit.basic.chapter10;

import java.util.ArrayList;
import java.util.LinkedList;


/*
    !! List 인터페이스 !!
    : 데이터를 "순차적"으로 저장하고 접근하는데 사용하는 메서드를 정의
    : 데이터의 "중복 저장"을 허용, 저장된 순서에 따라 데이터를 관리

    !! List 특징 !!
    - 요소의 인덱스를 통한 정확한 위치 지정
    - 요소의 중복 허용
    - 다양한 구현체를 통해 사용 가능

    === ArrayList VS LinkedList ===
    1) ArrayList : 읽기 작업이 많고, 삽입 삭제 적은 작업
    : 내부적으로 배열을 사용하여 요소 저장
    : 빠른 읽기, 느린 삽입/삭제 성능
    - 순차적으로 데이터를 관리 : 빠른 데이터 조회에 접합
    - 중간 삽입/삭제 시 : 데이터 이동이 필요하므고 상대적으로 성능 저하

    EX) 정렬된 책장
    책의 번호를 아는 경우 해당 책장에서 책을 빠르게 가져올 수 있음
    새 책을 책장의 중간에 추가할 경우 - 책을 모두 한칸씩 옮겨야 함 (시간이 오래 걸림)

    2) LinkedList : 삽입 삭제 많은 작업
    : 내부적으로 "이중 연결" 리스트를 사용하여 요소 저장
    : 빠른 삽입/삭제, 느린 데이터 접근 성능
    - 연결 기반 데이터 관리 : 비순차적 데이터 작업에 적합
    - 특정 요소 접근 시 : 순차 탐색이 필요하므로 성능 저하

    EX) 도서 대출 리스트
    새로운 대출 기록을 추가하거나 기존 기록을 제거하는 것에 용이
    : 옆의 요소와 연결만 변경하면 추가/삭제 가능
    특정 날짜의 대출 기록을 찾으러면 처음부터 하나씩 기록을 읽어야함 (시간이 오래 걸림)
 */
public class B_List {
    public static void main(String[] args) {
//        === List 인터페이스의 주요 메서드 ===

//        1. ArrayList 예제
        System.out.println("=== ArrayList 예제 ===");
//        cf) ArrayList 클래스 - AbstractList를 상속받음
//        AbstractList 추상 클래스 - List 인터페이스를 구현함
        ArrayList<String> arrayList = new ArrayList<>();

//        데이터 추가
        arrayList.add("Java"); // 리스트 끝에 요소 추가
        arrayList.add(0, "Python"); // 리스트 원하는 곳에 요소 추가
        arrayList.add("JavaScript");

        System.out.println(arrayList);

//        데이터 읽기 - 빠름
        String firstElement = arrayList.get(0); // 해당 인덱스 번호의 요소를 가져옴
        System.out.println(firstElement);

//        데이터 수정 - 요소를 찾아 변경
        arrayList.set(2, "TypeScript");
        System.out.println(arrayList);

//        데이터 삭제
        String removeElement = arrayList.remove(1); // 해당 인덱스 번호의 요소를 삭제하고 반환
        System.out.println(removeElement);
        System.out.println(arrayList);

//        리스트 크기
        System.out.println(arrayList.size());

//        리스트 비우기
        arrayList.clear();
        System.out.println(arrayList);

//        2. LinkedList 예제
        System.out.println("=== LinkedList 예제 ===");
        LinkedList<String> linkedList = new LinkedList<>();

//        데이터 추가
        linkedList.add("Apple");
        linkedList.add("Orange");
        linkedList.add("Mango"); // 리스트 끝에 요소 추가
        linkedList.add(1, "Banana"); // 리스트 원하는 곳에 요소 추가
        System.out.println(linkedList);

//        데이터 읽기
        String secondFruit = linkedList.get(1);
        System.out.println(secondFruit);

//        데이터 포함 여부 확인
        System.out.println("리스트에 Orange 포함? " + linkedList.contains("Orange"));
        System.out.println("리스트에 Strawberry 포함? " + linkedList.contains("Strawberry"));

//        데이터 삭제
        linkedList.remove(2);
        System.out.println(linkedList);

//        리스트 비우기
        linkedList.clear();
        System.out.println(linkedList);

//        === ArrayList VS LinkedList 성능 비교 ===
        System.out.println("=== ArrayList VS LinkedList 성능 비교 ===");

        ArrayList<Integer> arrayListTest = new ArrayList<>();
//        : 클래스 구조에는 객체 타입의 데이터만 삽입 가능
//        - 기본 데이터 타입 : int char boolean X
//        - 객체 형식 타입 : Integer, Character, Boolean O

        long startTIme = System.nanoTime();
//         현재 시간을 나노초 단위로 변환
//        1초 == 1,000,000,000 나노초
        for (int i = 0; i < 100000; i++) {
            arrayListTest.add(0, i); // 항상 맨 앞에 삽입
        }

        long endTime = System.nanoTime();
        System.out.println("ArrayList 삽입 시간 : " + (endTime - startTIme) + "ns");


        LinkedList<Integer> linkedListTest = new LinkedList<>();
        startTIme = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedListTest.add(0, i); // 항상 맨 앞에 삽입
        }
        endTime = System.nanoTime();
        System.out.println("linkedListTest 삽입 시간 : " + (endTime - startTIme) + "ns");
    }
}
