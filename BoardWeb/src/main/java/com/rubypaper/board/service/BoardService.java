package com.rubypaper.board.service;

import com.rubypaper.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface BoardService {
    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);

    Board getBoard(Board board);

    Page<Board> getBoardList();
}
