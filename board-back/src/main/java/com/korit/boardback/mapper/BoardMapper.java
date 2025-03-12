package com.korit.boardback.mapper;

import com.korit.boardback.entity.Board;
import com.korit.boardback.entity.BoardSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(Board board);
    List<BoardSearch> selectBoardListAllBySearchOption(
            @Param("startIdx") int startIdx,
            @Param("limitCount") int limitCount,
            @Param("order") String order,
            @Param("searchTxt") String searchTxt
    );
    int selectBoardListCountAllBySearchTxt(@Param("searchTxt") String searchTxt);
    List<BoardSearch> selectBoardListAllByUserIdAndCategoryAndSearchOption(
            @Param("userId") int userId,
            @Param("categoryName") String categoryName,
            @Param("startIdx") int startIdx,
            @Param("limitCount") int limitCount
    );
    int selectBoardCategoryListCountAllByUserIdAndCategoryName(
            @Param("userId") int userId,
            @Param("categoryName") String categoryName
    );
}
