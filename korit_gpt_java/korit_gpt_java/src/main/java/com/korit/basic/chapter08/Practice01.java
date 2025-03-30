package com.korit.basic.chapter08;

/*
    추상클래스
    : 모바일 애플리케이션
 */
abstract class MobileApp {
    //    추상 메서드
//    : 실행에 대한 동작 정의
//    - "반드시" 각 앱마다 "고유한 실행"을 정의
    abstract void execute();

    //    일반 메서드 구형 메서드
//    : 앱 정보 출력
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

// === 게임 애플리케이션 ===
class GameApp extends MobileApp {
    //    추상 메서드 구현
    @Override
    void execute() {
        System.out.println("Game app executes");
    }
}

// === SNS 애플리케이션 ===
class SocialApp extends MobileApp {
    String name;

    SocialApp(String name) {
        this.name = name;
    }

    //    추상 메서드 "구현"
    @Override
    void execute() {
        System.out.println(name + " app executes");
    }

    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social app");
    }

    //    SocialApp 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares : " + content);
    }

}

public class Practice01 {
    public static void main(String[] args) {
//        === 다형성 적용 ===
        MobileApp gameApp = new GameApp();
        MobileApp socialApp = new SocialApp("instagram");

//        다형성에 의해 공통 메서드는 호출 가능
        gameApp.execute();
        gameApp.appInfo(); // 부모 (추상)클래스의 일반 메서드
        socialApp.execute();
        socialApp.appInfo(); // 자식 클래스의 재정의 메서드

//        socialApp.shareContent("images"); // 고유의 메서드에 접근 불가
//        === 형 변환 ===
//        : MobileApp type -> SocialApp type으로 변환하여 고유 메서드 사용
        if (socialApp instanceof GameApp) {
            System.out.println("socialApp은 GameApp 입니다.");
            GameApp onlyGameApp = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            System.out.println("socialApp은 SocialApp 입니다.");
            SocialApp onlySocialApp = (SocialApp) socialApp;
            onlySocialApp.shareContent("images"); // 고유 메서드 사용 가능
        }

//        === 객체 배열과 다형성 활용 ===
//        뱌열 선언 & 초기화 : 데이터타입[] 변수명 = {요소 1, 2, 3...}
        int[] num = {1, 2, 3, 4, 5};
        MobileApp[] apps = {
//                생성과 동시에 업캐스팅 - 묵시적 형 변환
                new GameApp(),
                new SocialApp("facebook"),
                new SocialApp("twitter")
        };

        for (MobileApp app : apps) {
            app.execute();
            app.appInfo();

//            SocialApp 인지 확인 후 고유 메서드 사용 가능
            if (app instanceof SocialApp) {
//                다운 캐스팅 - 명시적 형 변환
                SocialApp specificSocialApp = (SocialApp) app;
                specificSocialApp.shareContent("Files");
            }
        }
    }
}
