package com.korit.basic.chapter04;

/*
    클래스변수 vs 인스턴스변수

    1. 형태
    - 클래스변수 : 데이터타입 앞에 static 키워드 명시
    - 인스턴스변수 : 일반 변수 선언
    
    2. 선언 위치
    - 모두 클래스 영역 내 선언
    
    3. 생성 시기 & 사용 시기
    - 클래스변수
        : 클래스가 메모리(Method Area)에 올라갈 때
        : 객체 생성 이전에도 사용 가능
   - 인스턴스변수
        : 인스턴스가 생성되었을 때
        : 객체 생성 이후에만 사용 가능
        
    4. 호출 방법
    - 클래스변수: 클래스명.변수명 
    - 인스턴스변수: 객체명.변수명
*/
class Example {
    int instanceValur;
    static int classValue;
}

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}

public class Object06 {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();
        Counter c5 = new Counter();
        System.out.println(c3.count);

        new Counter();
        new Counter();
        new Counter();
        new Counter();
        System.out.println(Counter.count);
    }
}
