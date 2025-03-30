package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean
    public ClassD call() {
        System.out.println("ConfigA call");
        return new ClassD(); // classD의 메소드 이름(classDCall)은 컴포넌트 이름(call)이 된다
//        ClassD에 @Component 어노테이션 안쓰고 직접 생성하는 이유
//        - 매개변수를 달리 줘야 할 경우
//        - 외부 라이브러리?를 Bean으로 등록하고 싶을 경우
    }
}
