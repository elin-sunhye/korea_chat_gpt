package com.korit.boardback.service;

import com.korit.boardback.dto.request.ReqBoardListSearchDto;
import com.korit.boardback.dto.request.ReqWriteBoardDto;
import com.korit.boardback.entity.*;
import com.korit.boardback.mapper.BoardMapper;
import com.korit.boardback.repository.BoardCategoryRepository;
import com.korit.boardback.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardCategoryRepository boardCategoryRepository;
    @Autowired
    private BoardMapper boardMapper;

    @Transactional(rollbackFor = Exception.class)
    public Board createBoard(String categoryName, User user, ReqWriteBoardDto reqWriteBoardDto) {
        BoardCategory boardCategory = boardCategoryRepository.findByName(categoryName).orElseGet(() -> {
            BoardCategory bc = BoardCategory.builder()
                    .boardCategoryName(categoryName)
                    .build();
            return boardCategoryRepository.save(bc);
        });

        Board board = Board.builder()
                .boardCategoryId(boardCategory.getBoardCategoryId())
                .userId(user.getUserId())
                .title(reqWriteBoardDto.getTitle())
                .content(reqWriteBoardDto.getContent())
                .build();
        return boardRepository.save(board);
    }

    public List<BoardCategoryAndBoardCount> getBoardCategoriesByUserId(User user) {
        return boardCategoryRepository.findAllByUserId(user.getUserId());
    }

    @Transactional(readOnly = true) // 읽기전용 최적화
    public List<BoardSearch> getBoardListAllBySearchOption(ReqBoardListSearchDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getLimitCount();

        return boardRepository.findBoardListAllBySearchOption(startIdx, dto.getLimitCount(), dto.getOrder(), dto.getSearchTxt());
    }

    public int getBoardListCountAllBySearchTxt(String searchTxt) {
        return boardRepository.findBoardListCountAllBySearchTxt(searchTxt);
    }

    @Transactional(readOnly = true)
    public List<BoardSearch> getBoardListAllByUserIdAndCategoryAndSearchOption(User user, String categoryName, ReqBoardListSearchDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getLimitCount();

        return boardRepository.findBoardListAllByUserIdAndCategoryAndSearchOption(user.getUserId(), categoryName, startIdx, dto.getLimitCount());
    }

    public int getBoardCategoryListCountAllByUserIdAndCategoryName(User user, String categoryName) {
        return boardRepository.findBoardCategoryListCountAllByUserIdAndCategoryName(user.getUserId(), categoryName);
    }
}
