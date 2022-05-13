package com.rubypaper.Chapter03.controller;

import com.rubypaper.Chapter03.domain.BoardVO;
import com.rubypaper.Chapter03.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    public BoardController() {
        System.out.println("===> BoardController 생성");
    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/hello")
    public String hello(String name) {
        return boardService.hello(name);
    }

    // View 없이 return 을 하면 JSON 데이터로 화면에 출력이 된다.
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        return boardService.getBoardList();
    }
}
