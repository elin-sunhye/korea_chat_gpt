package com.korit.korit_gpt_java_springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {
//    프론트 연결 시 서버 연결 확인 cross origin error 해경 방법 1
//    @CrossOrigin(value = "http://localhost:3000")
    @GetMapping("/server/hc")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "UP"));
    }
}
