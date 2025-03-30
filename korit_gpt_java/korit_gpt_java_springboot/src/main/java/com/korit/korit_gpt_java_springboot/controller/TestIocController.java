package com.korit.korit_gpt_java_springboot.controller;

import com.korit.korit_gpt_java_springboot.ioc.TestA;
import com.korit.korit_gpt_java_springboot.ioc.TestC;
import com.korit.korit_gpt_java_springboot.ioc.TestC1;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestIocController {

    @Qualifier(value = "testC1")
    @Autowired
    private TestC c;

    @Autowired
    private TestA a;

    @GetMapping("/api/testioc")
    public ResponseEntity<?> call() {
        c.textCCall();
        a.callTestA();
        return ResponseEntity.ok(null);
    }
}
