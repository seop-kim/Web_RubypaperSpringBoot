package com.rubypaper.Chapter03.service;

import com.rubypaper.Chapter03.domain.BoardVO;

import java.util.List;

public interface BoardService {
    String hello(String name);

    BoardVO getBoard();

    List<BoardVO> getBoardList();
}
