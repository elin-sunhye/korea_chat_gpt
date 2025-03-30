package com.korit.basic.chapter02;

import java.util.Scanner;

/*
    예제문제
*/
public class E_Practice {
    public static void main(String[] args) {

        // 1. 점수에 따른 학점 출력
        // 사용자로부터 점수를 입력받아 아래 기주넹 따라 학점을 출력
        // 0 미만 100 초과인 경우 :  유효하지 않은 점수입니다.
        // 90점 이상 : A
        // 80점 이상 : B
        // 70점 이상 : C
        // 60점 이상 : D
        // 그 외 : F

        Scanner sc = new Scanner(System.in);
        System.out.print("점수 : ");
        int score = sc.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("유효하지 않은 점수입니다.");
        } else if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
//        sc.close();

        // 2. 삼각형 모양의 별(*) 출력
        /*
         *
         **
         ***
         ****
         *****
         */
        for (int i = 1; i <= 5; i++) { // 줄 수
            for (int j = 1; j <= i; j++) { // 각 줄의 별의 개수 (각 줄의 별 개수는 각 줄의 수와 같다.)
                System.out.print('*');
            }
            System.out.println();
        }

        int rows = 5; // 줄 수
        for (int i = 1; i <= rows; i++) { // 1부터 rows까지 반복
            // 공백 반복 (4 ~ 0 감소)
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // 별 반복 (1 ~ 5 증가)
            for (int k = 1; k <= i; k++) {
                System.out.print('*');
            }

            System.out.println();
        }


        // cf) do-while문 예제
        // : 사영자 입력값을 반복적으로 받아 조건에 맞는 값을 처리할 때 유용

        int num;

        do {
            System.out.print("1부터 10사이의 숫자 입력 : ");
            num = sc.nextInt();

        } while (num < 1 || num > 10);  // 입력값이 1 ~ 10 사이일 때 반복 종료
        System.out.println("입력한 숫자는 ? " + num);
        sc.close();


        // cf) 동일한 입력 공간(System.in)을 여러번 여는 경우, 표준 입력 스트림을 닫고 재실행하는 경우 에러 발생
        // 운영체제 자원의 스트림이기 때문에 한번 닫으면 다시 열 수 없다.
    }
}
