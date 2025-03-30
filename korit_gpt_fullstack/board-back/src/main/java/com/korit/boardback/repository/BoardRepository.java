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

    public List<BoardSearch> findBoardListAllByUserIdAndCategoryAndSearchOption(int userId, String categoryName, int startIdx, int limitCount) {
        return boardMapper.selectBoardListAllByUserIdAndCategoryAndSearchOption(userId, categoryName, startIdx, limitCount);
    }

    public int findBoardCategoryListCountAllByUserIdAndCategoryName(int userId, String categoryName) {
        return boardMapper.selectBoardCategoryListCountAllByUserIdAndCategoryName(userId, categoryName);
    }
}
