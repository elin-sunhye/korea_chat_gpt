package com.korit.korit_gpt_java_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 특정 요청이 들어왓을 때(메서드가 실행 될 때) Model(모델) 객체에게 요청에 맞는 View 정보를 담아 DispatcherServlet에게 전송
 */

@Controller
public class FirstController {

    @GetMapping("/mvc/hello")
    public String hello(Model model) {
        model.addAttribute("name", "김선혜");

        System.out.println("hello method");
        System.out.println("hello method..");
        return "hello"; // 뷰 파일 경로 이다 프리픽스(/resource/templates/), 서픽스(.html)
    }

    @GetMapping("/mvc/hello2")
    public String hello2() {
        System.out.println("hello method3");
        return "hello2";
    }
}