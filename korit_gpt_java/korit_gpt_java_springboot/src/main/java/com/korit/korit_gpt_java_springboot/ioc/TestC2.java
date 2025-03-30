package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.stereotype.Component;

@Component
public class TestC2 implements TestC {
    @Override
    public void textCCall() {
        System.out.println("TestC2 call");
    }
}
