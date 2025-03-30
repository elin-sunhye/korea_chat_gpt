package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.security.annotation.JwtValid;
import com.korit.servlet_study.security.jwt.JwtProvider;
import io.jsonwebtoken.Claims;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/authenticated")
public class AuthenticatedServlet extends HttpServlet {
    private JwtProvider jwtProvider;

    public AuthenticatedServlet() {
        jwtProvider = JwtProvider.getInstance();
    }

    @JwtValid
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bearerToken = req.getHeader("Authorization");
        ObjectMapper objMapper = new ObjectMapper();
        System.out.println("bearerToken : " + bearerToken);

//        있는지 없는지만 확인
        ResponseDto<?> responseDto = null;
        if (bearerToken == null) {
            responseDto = ResponseDto.forbidden("Not found Token");

            resp.setStatus(responseDto.getStatus());
            resp.setContentType("application/json");
            resp.getWriter().println(objMapper.writeValueAsString(responseDto));

            return;
        }

//        claims 유효 검증
        Claims claims = jwtProvider.parseToken(bearerToken);
        if (claims == null) {
            responseDto = ResponseDto.forbidden("Not Access Token");

            resp.setStatus(responseDto.getStatus());
            resp.setContentType("application/json");
            resp.getWriter().println(objMapper.writeValueAsString(responseDto));

            return;
        }

        responseDto = ResponseDto.success(claims.get("userId")); // generateTokenak 만들때 넣은 userID (로그인한 계정의 userId)

        resp.setStatus(responseDto.getStatus());
        resp.setContentType("application/json");
        resp.getWriter().println(objMapper.writeValueAsString(responseDto));


    }
}
