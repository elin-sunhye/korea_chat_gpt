package com.korit.basic.chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        // 2. Switch문
        // : 특정변수의 값에 따라 실행 할 코드 블록의 범위 결정
        // : 비교할 변수와 case 값을 비교하여 같은 값일 경유 해당 블록부터 끝까지 실행
        // : break 키워드에서 switch문 종료
        // boolean 안됨
        
       /* switch (조건변수) {
            case 조건값1:
                실행 문장;
            case 조건값2:
                실행 문장;
                break;
            case 조건값3:
                실행 문장;
                break;
            default:
                case 조건식이 끝난 뒤 작성 : 어느 case에도 일치하지 않을 경우
                실행문장;
        }*/

        Scanner sc = new Scanner(System.in);

        System.out.print("Chapter를 선택하세요:) ");
        int chapter = sc.nextInt();

        switch (chapter) {
            case 1:
                System.out.println("자바 기본 문법");
                break;
            case 2:
                System.out.println("자바 제어문 = 조건문/반복문");
                break;
            case 3:
                System.out.println("자바 배열");
                break;
            default:
                System.out.println("유효한 chapter가 아닙니다.");
        }

        // 버퍼 처리 : chapter nextInt() 뒤의 개행 문자 처리
        sc.nextLine();

        System.out.print("과일을 입력하세요:) ");
        String fruits = sc.nextLine();

        switch (fruits) {
            case "banana":
                System.out.println("바나나");
                break;
            case "strawberry":
                System.out.println("딸기");
                break;
            case "grape":
                System.out.println("포도");
                break;
            default:
                System.out.println("과일이 아닙니다.");
        }

        sc.close();
    }
}
