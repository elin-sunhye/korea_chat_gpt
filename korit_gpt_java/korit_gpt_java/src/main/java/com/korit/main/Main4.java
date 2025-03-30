package com.korit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numberList2 = null;
        List<Integer> numberList3 = null;

        numberList2 = new ArrayList<>();

//        for(int i =0; i < numberList.size(); i++){
//            int num = numberList.get(i);
//
//            numberList2.add(num * 10);
//        }

        for(Integer num : numberList) {
            numberList2.add(num * 10);
        }


        numberList3 = numberList.stream() // 데이터를 저장하지 않는다, 한번 쓰고 다시 재사용할 수 없다
                .map(num -> num * 10)
                .collect(Collectors.toList());

        System.out.println(numberList);
        System.out.println(numberList2);
        System.out.println(numberList3);


        List<Integer> numberList4 = null;
        numberList4 = new ArrayList<>();
//        또는
//        List<Integer> numberList4 = new ArrayList<>();

//        호이스팅 에러
//        numberList.forEach(num -> numberList4.add(num * 10)); 인텔리제이에서만 뜸.
        test( new ArrayList<>(numberList4), numberList);
    }

    public static void test(ArrayList<Number> list, List<Integer> numList) {
        numList.forEach(num -> list.add(num * 10));

        System.out.println("43 : " + list);
    }
}
