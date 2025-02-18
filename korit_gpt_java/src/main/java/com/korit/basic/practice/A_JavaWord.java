package com.korit.basic.practice;

public class A_JavaWord {
    /*
        === 접근제한자(Access Modifiers) ===
        public : 프로젝트 내 접근가능
        protected : 패키지 내에서 접근 / 다른 패키지일 경우 상속 받은 클래스에서만 접근 가능
        default : 패키지 내에서만 접근 가능
        private : 클래스 내에서만 접근 가능
     */

    /*
        === static ===
        : 인스턴스화를 하지 않고 사용할 수 있는 변수 또는 메서드
        : 클래스, 정적
        static 변수 :  클래스명.변수명
        static 메서드 : 클래스명.메서드명
     */

    /*
        === final ===
        : 활용, 응용, 변경되지 않는 최종적인 데이터
        final 변수 : final 데타 변수명;
        final 메서드: final 반환타입 메서드명() {}
        final 클래스: (접근제어자) final class 클래스명 {}
     */

    /*
        === super VS this ===
        this : 같은 클래스 내의 다른 생성자 또는 필드 호출
                - this.필드명 / this.메서드명 / this() - 생성자
        super : 상속 받은 부모 클래스 내의 생성자 또는 필드 호출
                - super.필드명 / super.메서드명 / super() - 생성자
     */

    /*
        === 오버로딩(Overloading) vs 오버라이딩(Overriding) ===
        오버로딩 : 같은 클래스 내 같은 이름의 메서드를 작성
                    - 파라미터 개수 또는 데타가 달라야함
                    - 반환 타입은 상관없음
        오버라이딩 : 부모 클래스로 상속 받은 메서드를 자식 클래스에서 '재정의'
                    - 클래스명, 매개 변수 구성 동일하게 사용
                    - 반환 타입은 같거나 자동 형 변환 가능하게 작성
     */

    /*
        === 업캐스팅(Upcasting) VS 다운캐스팅(Downcasting) ===
        업캐스팅 : 자식 -> 부모
        다운캐스팅 : 업캐스팅이 된 객체를 다시 돌리는 것
    */
    /*
        === 추상 클래스(abstract) VS 인터페이스(interface) ===
        : 추상 메서드 구현부 없음
        : 자식 클래스 고유 메서드, 필드 접근 불가 -> 자식 타입으로 다운캐스팅한 후 사용 가능
        추상 클래스 : abstract class 클래스명 {} / abstract 메서드명();
                - 다중 상속 X extends 키워드 사용
        인터페이스 : interface class 클래스명 {}
                    : 상호작용하기 위한 약속
                    - 기본 메서드 생성 시 public abstract 특성
                    - 기본 변수(필드) 생성 시 public static final 특성
                    - 다중 구현 가능 implement 키워드 사용
     */
}
