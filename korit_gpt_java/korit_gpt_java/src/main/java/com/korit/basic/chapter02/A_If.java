package com.korit.basic.chapter02;

import java.util.Scanner;

// 제어문 : 조건문(Condition), 반복문(Loop)

/*
    조건문 : 프로그램의 흐름을 제어하는데 사용
        종류
            1. if, else, else if
            2. switch, case, default
            +) continue, break
*/
public class A_If {
    public static void main(String[] args) {
        // 1. if문 / else문
        /*
            if(조건식) {
                조건이 참 실행
             } else {
                조건이 거짓 실행
             }
        */
        int age = 10;
        if (age > 19) {
            System.out.println("성인");
        } else {
            if (age > 13) {
                System.out.println("청소년");
            } else {
                System.out.println("미성년자");
            }
        }

        age = 15;
        if (age > 19) {
            System.out.println("성인");
        } else if (age > 13) {
            // 13 < age < 19
            System.out.println("청소년");
        } else {
            System.out.println("미성년자");
        }

        // cf) 실행될 코드 블럭에 코드가 하나의 구문으라면 {} 생략 가능
        age = 20;
        if (age > 19) System.out.println("주류");
        else if (age > 13) System.out.println("탄산");
        else System.out.println("주스");
        System.out.println();


        // == 조건문 예제 ==
        // : 함수 위치 구하기 문제
        // 1. 스캐너를 사용하여 x y 변수에 데이터 저장
        // 2. (x, y) 좌표가 1,2,3,4 사분기 중 어느 위치에 있는지 검사
        // >> 조건문
        // 각 분기의 위치일 경우 functionScope 변수에 몇 사분면인지 할당
        // EX) functionScope = "제 1 사분면"
        // 조건문 이행 완료 시
        // "결과 : " + functionScope 출력

        // === 풀이 === //
        // 각 조건식에서 저장할 문자열 값 (사분면의 위치)을 담을 변수 선언
        String functionScope = null; // 비워있다.

        // 스캐너 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.print("y : ");
        int y = sc.nextInt();

        // 조건문 작성
        if (x > 0 && y > 0) {
            // (+,+)
            functionScope = "제 1 사분면";
        } else if (x < 0 && y > 0) {
            // (-,+)
            functionScope = "제 2 사분면";
        } else if (x < 0 && y < 0) {
            // (-,-)
            functionScope = "제 3 사분면";
        } else {
            // (+,-)
            functionScope = "제 4 사분면";
        }

        // 출력
        System.out.println("결과: " + functionScope);

        // 스캐너 종료
        sc.close();
    }
}
