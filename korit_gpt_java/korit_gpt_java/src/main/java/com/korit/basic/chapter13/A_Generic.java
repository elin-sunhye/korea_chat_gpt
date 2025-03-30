package com.korit.basic.chapter13;

/*
    === 제네릭 (Generic, 일반적인) ===
    : 데이터 타입(type)을 "일반화"하는 것
    : 클래스나 메서드의 데이터타입을 미리 지정하지 않고, 구체적인 타입은 사용하는 시점에 지정할 수 있도록 설계된 기능
    - 특정 타입에 의존하지 않고, 다양한 타입을 지언하는 클래스 또는 메서드 설계 가능

    1. 제네릭 사용 목적
    - 타입 안정성
    - 코드 재사용성
    - 가독성

    2. 제네릭 클래스
    : class 클래스명<제네릭타입> {
        - 제네릭 타입을 사용하여 필드, 생성자, 메서드 정의
    }
*/

// '키' - '값'을 쌍을 저장
class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    //    제네릭 메서드
//    (접근제한자 static) <제네릭 타입> 반환타입 메서드명(매개변수...){}
//    : 메서드 호출 시 전달된 타입에 따라 T가 결정
    static <T> void print(T value) {
        System.out.println(value);
    }

//    cf) 타입 변수
//    : Type의 앞글자를 따 서 <T>형식을 주로 사용
}

public class A_Generic {
    public static void main(String[] args) {
/*
            제네릭 클래스 사용 방법
            클래스명<제네릭타입> 인스턴스명 = new 클래스명<>();

            cf) 제네릭 타입 명시는 필수 X
            : 제네릭 타입의 구조에 값이 들어올 경우 해당 값으로 타입을 유추

            제네릭 타입의 경우 클래스 형시의 참조 자료향을 사용
            : Wrapper 자료형
            int >> Integer
            boolean >> Boolean
            char >> Character
*/
        Pair<Integer, String> pair1 = new Pair<>(4343, "안녕");
        Pair<String, Integer> pair2 = new Pair<>("안녕", 4343);


        System.out.println(pair1.getKey());
        System.out.println(pair2.getKey());

        Pair.<String>print("하이");
        Pair.<Integer>print(1234);
    }
}
