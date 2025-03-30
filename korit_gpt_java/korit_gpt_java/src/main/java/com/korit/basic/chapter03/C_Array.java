package com.korit.basic.chapter03;

import java.util.Arrays;

/*
    Arrays 클래스
    : 배열을 조작하는데 유용한 기능들을 제공해주는 자바 내부 클래스
    >> 정렬, 검색, 변환 등

    .(마침표) : 해당 클래스 내부의 기능을 사용
*/


public class C_Array {
    public static void main(String[] args) {
        // === Arrays 클래스 사용법 === //

        // 배열 생성 방법
        int[] numbers = {3, 2, 5, 4, 1};

        // 1. 배열 정렬
        //  1) 오름차순 (가.나.다.)
        //  Arrays.sort(배열);
        Arrays.sort(numbers);
        System.out.println(numbers[0]);
        System.out.println();

        // 2. 배열 변환
        // Arrays.toString(배열);
        // : 각 요소를 순회하며 배열의 전체 구조를 파악
        System.out.println(numbers); // [I@3ac3fd8b
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
        System.out.println();

        // 3. 배열 내 검색
        // Arrays.binarySearch(배열, 검색내용);
        // : 존재하면 존재하는 요소의 인덱스 반환
        // : 존재하지 않으면 음수 반환
        System.out.println(Arrays.binarySearch(numbers, 1));
        System.out.println(Arrays.binarySearch(numbers, 5));
        System.out.println(Arrays.binarySearch(numbers, 6));
        System.out.println();

        // 4. 배열 비교
        // Arrays.equals(a배열, b배열);
        // : 논리형태로 반환 (true, false)
        int[] numbers2 = {1, 2, 3, 5, 4};
        System.out.println(Arrays.equals(numbers, numbers2)); // false

        int[] numbers3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.equals(numbers, numbers3)); // true
        System.out.println();

        // 5. 배열 채움
        // Arrays.fill(배열, 삽입할 값);
        // : 배열의 모든 요소를 특정 값으로 채움
        int[] ex = new int[3];
        System.out.println(Arrays.toString(ex)); // {0, 0, 0}

        Arrays.fill(ex, 10);
        System.out.println(Arrays.toString(ex)); // {10, 10, 10}
    }
}
