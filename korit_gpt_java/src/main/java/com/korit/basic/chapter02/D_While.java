package com.korit.basic.chapter02;

public class D_While {
    public static void main(String[] args) {
        // 2.
        // : 반복 횟수가 지정되지 않을 때 사용

        // 조건을 검사하고 해당 조건이 true 인 경우 코드 블록을 실행
        // > if문의 반복 형태

        // 초기화
        // while문 (반복문 내에서 증감)
        /*
            while (조건) {
                조건이 참일 때 실행
            }
        */

        int num = 1;
        while (num <= 5) {
            System.out.println(num);
            num++;
        }

        // cf) while문 내부에서 코드 블럭을 계속해서 실행: continue;
        //     while문의 코드 블럭 중단 : break;

        System.out.println();

        // === 예제 === //
        // 0부터 20까지의 정수 중에서 홀수만 출력
        int number = 0;
        while (true) { // 무한루프 (while문 내부에서 break; 키워드를 만나기 전까지 실행
            if (number % 2 == 0) {
                // 짝수
                number++;
                continue; // 루프안에서 continue;를 만나면 아래의 코드를 무시하고 다시 조건 검사
            }

            // 홀수만 아래의 내용이 실행
            System.out.println(number);
            number++;

            if (number == 20) break;
        }

        System.out.println();

        // cf) do while문
        // while문과의 차이점 : 코드 블록이 최소 한번은 반드시 실행

        /*
            do {
                 실행할 코드
            } while (조건);
        */

        num = 1;
        do {
            System.out.println(num);
            num++;
        } while (num <= 5);
    }
}
