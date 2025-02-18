package com.korit.basic.chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
    java.time 패키지
    : ISO-8601 표준을 기반으로 설계
    : 날짜와 시간의 형태를 무조건 yyyy-MM-ddTHH:mm:ss.sssZ 형태로 출력
 */
public class JavaTime {
    public static void main(String[] args) {
        System.out.println("=== LocalDate ===");
//        1) LocalDate(날짜)
//        : 날짜 (연도, 월, 일)
//        .now() - 현재 날짜 반환 (static 메서드)
//        .of(연도, 월, 일) - 특정 날짜 반환 (static 메서드)
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate specificDate = LocalDate.of(2025, 4, 3);
        System.out.println(specificDate);

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDate oneMonthAge = today.minusMonths(1);
        System.out.println(oneMonthAge);

        System.out.println("=== LocalTime ===");
//        2) LocalTime(시간)
//        : 시간(시, 분, 초, 나노초)
//        날짜와 시간대 정보는 불포함
//        .now() - 현재 시간 반환 (static 메서드)
//        .of(시, 분, 초) - 특정 시간 반환 (static 메서드)
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime specificTime = LocalTime.of(14, 30);
        System.out.println(specificTime);

        LocalTime thirtyThreeMinutesLater = now.plusMinutes(33);
        System.out.println(thirtyThreeMinutesLater);

        LocalTime oneHourAgo = now.minusHours(1);
        System.out.println(oneHourAgo);

//        cf) get 메서드
//        getYear(), getMonth(), getDayOfMonth() : 날짜 정보 반환
//        getHour(), getMinute(), getSecond() : 시간 정보 반환
        System.out.println(today.getMonth()); // DECEMBER - 키워드 반환
        System.out.println(now.getHour()); // 12

//        cf) LocalDateTIme 클래스
//        : 날짜와 시간을 함께 다루는 클래스
//        .now(), .of(), .plus~(), .minus~() 사용 가능
        LocalDateTime nowDateTIme = LocalDateTime.now();
        System.out.println(nowDateTIme);
        System.out.println(nowDateTIme.toLocalDate());
        System.out.println(nowDateTIme.toLocalTime());

//      cf) 날짜와 시간 포맷팅(formatting)
        LocalDateTime example = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(example.format(formatter));
    }
}
