package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.dto.InsertBoardDto;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.entity.Board;
import com.korit.servlet_study.service.BoardService;
import com.korit.servlet_study.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/board")
public class BoardRestServlet extends HttpServlet {
    private BoardService boardService;

    public BoardRestServlet() {
        boardService = BoardService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder stringBuilder = new StringBuilder();

//        try () : 자동 close 해줌
        try (BufferedReader bufferedReader = req.getReader()) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
//                뮨자열 합쳐줌
                stringBuilder.append(line);
            }
        }

        ObjectMapper objMapper = new ObjectMapper();
//        JSON을 InsertBoardDto 타입 객체로 변환
        InsertBoardDto insertBoardDto = objMapper.readValue(stringBuilder.toString(), InsertBoardDto.class);
        System.out.println(insertBoardDto);

        ResponseDto<?> responseDto = boardService.insertBoard(insertBoardDto);
        String responseJson = objMapper.writeValueAsString(responseDto);

        resp.setStatus(responseDto.getStatus());
        resp.setContentType("application/json");
        resp.getWriter().println(responseJson);
    }
}
