package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

    @Autowired
    private ClassD d;

    public void classCallA() {
        System.out.println("ClassA method 호출");
    }
}
