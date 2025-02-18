package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.stereotype.Component;

@Component
public class TestA {
    public void callTestA() {
        System.out.println("TestA call");
    }
}
