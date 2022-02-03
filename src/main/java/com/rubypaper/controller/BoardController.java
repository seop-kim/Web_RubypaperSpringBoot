package com.rubypaper.controller;

import com.rubypaper.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {

    public BoardController() {
        System.out.println("===> BoardController 생성");
        System.out.println(getBoard().toString());
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello : " + name;
    }

    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("Test Title...");
        board.setWriter("Tester");
        board.setContent("Test Content.....");
        board.setCreateDate(new Date());
        board.setCnt(0);

        return board;
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();

        for (int i = 1; i <= 10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("Test Title... : " + i);
            board.setWriter("Tester : " + i);
            board.setContent("No : " + i + " Test Content.....");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }

        return boardList;
    }


}
