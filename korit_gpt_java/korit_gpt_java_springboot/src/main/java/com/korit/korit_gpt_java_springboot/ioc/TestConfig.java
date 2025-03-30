package com.korit.korit_gpt_java_springboot.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public void callTest() {
        System.out.println("testConfig call");
//        return
        new TestD().callTestD();
    }
}
