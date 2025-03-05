package com.korit.boardback.repository;

import com.korit.boardback.entity.Board;
import com.korit.boardback.entity.BoardSearch;
import com.korit.boardback.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private BoardMapper boardMapper;

    public Board save(Board board) {
        boardMapper.insertBoard(board);
        return board;
    }

    public List<BoardSearch> findBoardListAllBySearchOption(int startIdx, int limitCount, String order, String searchTxt) {
        return boardMapper.selectBoardListAllBySearchOption(startIdx,limitCount ,order,searchTxt);
    }

    public int findBoardListCountAllBySearchTxt(String searchTxt) {
        return boardMapper.selectBoardListCountAllBySearchTxt(searchTxt);
    }
}
