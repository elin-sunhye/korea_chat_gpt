package com.korit.servlet_study.dao;

import com.korit.servlet_study.config.DBConnectionMgr;
import com.korit.servlet_study.dto.InsertBoardDto;
import com.korit.servlet_study.entity.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class BoardDao {
    private DBConnectionMgr mgr;
    private static BoardDao instance;

    //    싱글톤
    public static BoardDao getInstance() {
        if (instance == null) {
            instance = new BoardDao();
        }

        return instance;
    }

    //    생성자
    private BoardDao() {
        mgr = DBConnectionMgr.getInstance();
    }

    //    저장 메서드
    public Board save(Board board) {
        Board insertedBoard = null;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = mgr.getConnection();
            String sql = """
                    insert into board_tb
                    values(default, ?, ?)
                    """;

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            ps.executeUpdate();

//
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insertedBoard = Board.builder()
                        .boardId(rs.getInt(1))
                        .title(board.getTitle())
                        .content(board.getContent())
                        .build();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            mgr.freeConnection(conn, ps);
        }

        return insertedBoard;
    }
}
