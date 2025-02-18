package com.korit.basic.chapter02;

/*
    반복문
    : 특정 조건이 만족될 때까지 동일한 작업을 반복적으로 실행
        종류
            1. for
            2. while
            +) do-while
*/

public class C_For {
    public static void main(String[] args) {
        // 1. for문
        // : 특정 조건이 만족될 때까지 코드 블럭을 반복 실행
        // > 횟수가 정해져 있을 때 사용

        /*
            for(초기화1; 조건식2; 증감식3) {
                조건 만족 시 실행 코드4
            }
            
            초기화 : 반복에 사용할 변수
            조건식 : 해당 조건이 참인 동안 반복문이 실행
            증감식 : 매 반복마다 변수를 증감

            실행순서 : 1 > (2 > 4 > 3)
        */

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println();

        // === 예제 === //
        // for 반복문을 사용하여 1부터 10까지의 숫자중 짝수만 출력
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }


        // for 반복문을 사용하여 구구단의 일부를 출력
        System.out.println();
        System.out.println("=== 3단 ===");
        // 3 X 1 = 3 으로 출력
        int num = 3;
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 0) {
                System.out.println(num + "X" + i + "=" + num * i);
            }
        }

        // 중첩 for문(반복문)
        System.out.println();
        System.out.println("=== 구구단 전체 출력 ===");
        // 2단 ~ 9단 반복 내부에서 1 ~ 9까지 반복
        // 반복하는 횟수를 명확하게 확인 : 초기화0, 조건을 횟수 미만으로 설정
        for (int i = 0; i < 8; i++) {
            int dan = i + 2; // 2단부터 9단까지 반복
            System.out.println("[" + dan + "]");


            // 곱셈식에 들어갈 반복문
            for (int j = 0; j < 9; j++) {
                int number = j + 1;

                System.out.println(dan + "X" + number + "=" + (dan * number));
            }
        }

        int i = 0; // 같은 스코프(범위 {}) 내의 변수가 아니기 때문에 i 변수 선언 가능
    }
}
