package com.korit.korit_gpt_java_springboot.controller;

import com.korit.korit_gpt_java_springboot.ioc.ClassA;
import com.korit.korit_gpt_java_springboot.ioc.ClassB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IocController {

    private final ClassA a;
    private final ClassB b;

    @GetMapping("/api/ioc")
    public ResponseEntity<?> call() {
        a.classCallA();
        b.classCallB();
        return ResponseEntity.ok(null);
    }
}
