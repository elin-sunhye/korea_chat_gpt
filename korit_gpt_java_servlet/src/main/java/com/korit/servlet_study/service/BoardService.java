package com.korit.servlet_study.service;

import com.korit.servlet_study.dao.BoardDao;
import com.korit.servlet_study.dto.InsertBoardDto;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.entity.Board;

public class BoardService {
    private BoardDao boardDao;
    private static BoardService instance;

    //    싱글톤
    public static BoardService getInstance() {
        if (instance == null) {
            instance = new BoardService();
        }
        return instance;
    }

    //    생성자
    private BoardService() {
        boardDao = BoardDao.getInstance();
    }


    //    <?> : 와일드 카드
    public ResponseDto<?> insertBoard(InsertBoardDto dto) {
        Board board = dto.toBoard();
        Board insertedBoard = boardDao.save(board);

        if (insertedBoard == null) {
            return ResponseDto.fail("Fail to add board");
        }

        return ResponseDto.success(insertedBoard);
    }

}
