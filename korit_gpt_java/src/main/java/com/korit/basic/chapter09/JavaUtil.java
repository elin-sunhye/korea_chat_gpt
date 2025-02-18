package com.korit.basic.chapter09;

import java.util.Calendar;
import java.util.Date;

/*
    java.util 패키지
    : 자바 표준 라이브러리 중 하나
    - 데이터의 구조, 사관과 날짜 처리, 무작위 숫자 생성 등의 기능 제공
    - 외부에 있는 클래스를 import 하여 사용

    === 시간과 날짜 처리 클래스 ===
    1. Date 클래스
    : 날짜와 시간을 표현
    : 현재의 밀리초 단위까지 반환 (1000밀리초 == 1초)

    2. Calendar 클래스
    : 날짜와 시간을 조작하거니 필드를 개별적으로 제어할 수 있는 도구
    - '추상 클래스'이며 getInstance() 메서드를 통해 구현 객체를 반환받아 사용

    3. java.time 패키지
    : 날짜와 시간을 다루는 도구 (명확성과 유연성 제공)
    - java.util Date, Calendar의 문제점을 보완
 */
public class JavaUtil {
    public static void main(String[] args) {
        System.out.println("=== Date class ===");
//        1. Date 클래스
//        : 데이트 객체를 생성하여 인스턴스 필드와 메서드를 활용
        Date date = new Date();

//        1) toString() : 날짜와 시간을 문자열로 반환
        System.out.println("현재 날짜와 시간 : " + date.toString());

//        2) getTIme() : 1970년 1월 1일 00:00:00 (UTC) 기준으로 현재 시간까지의 밀리초(ms)를 반환
//        UTC : 시간대의 기준점 (한국 시간 == UTC + 09:00:00)
//        (오늘 날짜 + 09:00:00) - (어제 날짜 + 09:00:00)
        System.out.println("현재 시간의 밀리초 : " + date.getTime());

        System.out.println("=== Calendar class ===");
//        2. Calendar 클래스
//        1) getInstance() : "현재 날짜"와 시간으로 초기화된 Calendar 객체를 반환
        Calendar calendar = Calendar.getInstance(); // static 메서드

//        2) get(int field) : 지정된 필드의 값을 반환
//        Calendar.YEAR / .MONTH /.DAY_OF_MONTH
        System.out.print(calendar.get(Calendar.YEAR));
//        month(월) : 0 ~ 11 까지의 수로 반환
        System.out.print(calendar.get(Calendar.MONDAY) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

//        3) set(int year, int month, int date) : 날짜 설정
        calendar.set(2025, 3, 14);
        System.out.print(calendar.get(Calendar.YEAR));
        System.out.print(calendar.get(Calendar.MONDAY));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
