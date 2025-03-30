package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.entity.User;
import com.korit.servlet_study.security.annotation.JwtValid;
import com.korit.servlet_study.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/user")
public class UserRestServlet extends HttpServlet {
    private UserService userService;

    public UserRestServlet() {
        userService = UserService.getInstance();
    }

    @JwtValid
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        토큰이 있는지 검증 : 주소 url을 치고 들어올 수 없게!


        String userIdParam = req.getParameter("userId");
        int userId = Integer.parseInt(userIdParam);
        ResponseDto<?> responseDto = userService.getUser(userId);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(responseDto);
        System.out.println(jsonUser);

//        Origin = 출처 대상(서버) : http://localhost:3000
//        * : 전체
        resp.setHeader("Access-Control-Allow-Origin", "*");

//        "POST, GET, OPTIONS" 이외 요청은 받지 않겠다 (delete..등)
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");

//        Content-Type 으로 셋팅해서 데이터를 주겠다
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

//        쿠키 등 중요 데이터 접금 방지 (true하면 접근 방지)
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        resp.setContentType("application/json");
        resp.getWriter().write(jsonUser);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
