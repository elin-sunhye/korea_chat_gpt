package com.korit.basic.chapter09;

/*
    API(Application Programming Interface)
    : 소프트웨어 또는 시스템 간 상호작용을 가능하게 하는 정의된 메서드의 집합
    : 소프트웨어나 하드웨어와 상호작용할 수 있는 인터페이스 제공

    JAVA API 클래스
    : 자바 프로그래밍 내에서 미리 정의된 클래스와 메서드의 집합
    - JAVA API는 표준 자바 라이브러리로 제공
    - 다양한 패키질 나뉘며, 각 패키지는 특정 기능을 담당

    1. java.lang 패키지
    : 기본 클래스와 메서드를 제공 (String, Math, System 등)
    - 자동으로 포함 : import 없이 사용 가능

    2. java.io 패키지
    : 입출력과 관련된 클래스 (input, output)
    - File, InputStream 등과 같은 외부의 입출력과 관련

    3. java.util
    : 유틸리티 클래스 (List, Map, Date 등)

    JAVA API 공식 문서
    https://docs.oracle.com/javase/8/docs/api/
 */

public class JavaApi {
    public static void main(String[] args) {
//        1) java.lang
        String message = "Hello Java";
        System.out.println(message.length()); // 문자열 길이 출력

        double result = Math.sqrt(25); // square root
        System.out.println(result);

        System.out.println();
//        : System 클래스의 API를 호춯하여 콘솔에 메시지 출력
    }
}
