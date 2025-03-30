package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.stereotype.Component;

@Component
public class ClassC2 implements ClassC {
    @Override
    public void classClassC() {
        System.out.println("ClassC2 method 호출");
    }
}
