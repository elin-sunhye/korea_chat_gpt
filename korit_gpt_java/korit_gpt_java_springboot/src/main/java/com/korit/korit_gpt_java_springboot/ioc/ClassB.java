package com.korit.korit_gpt_java_springboot.ioc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    @Autowired
    private ClassC c1; // 변수명이 컴포넌트 이름이여야한다 다르다면 해당 컴포넌트에 이름이 변경하거나 @Qualifier 어노테이션 사용

    // 변수명이 컴포넌트 이름과 같지 않다면 사용, 같으면 생략 가능 -> @Qualifier(value = "classC2") || @Qualifier("classC2")
    @Qualifier("classC2")
    @Autowired
    private ClassC c2;

    public void classCallB() {
        System.out.println("ClassB method 호출");
    }
}
