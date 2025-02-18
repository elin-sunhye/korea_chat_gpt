package com.korit.main;

import com.korit.util.ForEachPrinter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Generic 제네릭
    - T : 참조형 자료형 또는 wrapper(일반 자료형인데 클래스로 만든 것) 자료형만 사용
*/
public class Main3 {
    public static boolean test() {
//        boolean result = false;
//        result =  10 % 2 == 0;
//        return result;

        return 10 % 2 == 0;
    }

    public static void main(String[] args) {
        String[] names = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
        Integer[] nums = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForEachPrinter2.print(names);
        ForEachPrinter2.print(nums);

//        반환 제네릭 타입
        List<String> datas =  ForEachPrinter2.printR(Arrays.asList(names), data -> System.out.println(data));

//        === collection ===
//        list, set, map
        List<Integer> list = List.of(1,2,3,4,5);
//        List.of : 추가, 삭제 안됨 : 수정 안됨 -> 불변 리스트
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.add(10);
//        ||
        List<Integer> list3 = list.stream().collect(Collectors.toList());
        list3.add(20);


    }
}
