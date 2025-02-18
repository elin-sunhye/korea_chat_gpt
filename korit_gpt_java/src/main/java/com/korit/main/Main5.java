package com.korit.main;


//    이거 람다용이니까 추상 메소드 추가 하묜 안돼 == @FunctionalInterface
@FunctionalInterface
interface 무기 {
    String 공격(Integer 데미지);
}

class 총 implements 무기 {
    @Override
    public String 공격(Integer 데미지) {
        System.out.println("데미지 : " + 데미지);
        System.out.println("총을 쏜다");

        return "데미지 : " + 데미지 + ", 총을 쏜다";
    }
}

public class Main5 {
    public static void main(String[] args) {
//        엡캐스팅
        무기 wp1 = new 총();

//        익명 클래스
        무기 wp2 = new 무기() {
            @Override
            public String 공격(Integer 데미지) {
                System.out.println("데미지 : " + 데미지);
                System.out.println("커스텀 칼을 휘두르다");

                return "데미지 : " + 데미지 + ", 커스텀 칼을 휘두르다";
            }
        };

//        wp1.공격(100);
//        wp2.공격(50);
        System.out.println(wp1.공격(12));
        System.out.println(wp2.공격(143));

//        람다
        무기 wp3 = (Integer 데미지) -> {
            System.out.println("데미지 : " + 데미지);
            System.out.println("커스텀 람다 ㄱㄱ");
            return "데미지 : " + 데미지 + ", 커스텀 람다 ㄱㄱ";
        };
//        wp3.공격(300);
        System.out.println(wp3.공격(3355));

//        매개 변수 자료형 생략 가능
        무기 wp4 = (데미지) -> {
            System.out.println("데미지 : " + 데미지);
            System.out.println("커스텀 람다 ㄱㄱ");
            return "데미지 : " + 데미지 + ", 커스텀 람다 ㄱㄱ";
        };
//        wp4.공격(1000);
        System.out.println(wp4.공격(9));

//        매개 변수가 하나면 ()도 생략 가능
        무기 wp5 = 데미지 -> {
            System.out.println("데미지 : " + 데미지);
            System.out.println("커스텀 람다 ㄱㄱ");
            return "데미지 : " + 데미지 + ", 커스텀 람다 ㄱㄱ";
        };
//        wp5.공격(1000);
        System.out.println(wp5.공격(64));

//        리턴값이 있는 경우 졸괄호{}를 생략하고 바로 리턴 값을 입력 할 수 있다.
        무기 wp6 = 데미지 -> "데미지 : " + 데미지 + ", 커스텀 람다 ㄱㄱ";

//        wp6.공격(1000);
        System.out.println("ㅁㄴ" + wp6.공격(64));
    }
}
