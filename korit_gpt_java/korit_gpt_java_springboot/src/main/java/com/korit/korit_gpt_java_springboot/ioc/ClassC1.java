package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.stereotype.Component;

@Component(value = "c1")
public class ClassC1 implements ClassC {
    @Override
    public void classClassC() {
        System.out.println("ClassC1 method 호출");
    }
}
