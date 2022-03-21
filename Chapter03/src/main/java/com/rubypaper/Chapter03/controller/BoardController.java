package com.rubypaper.Chapter03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.Chapter03.domain.BoardVO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}

	// View 없이 return 을 하면 JSON 데이터로 화면에 출력이 된다.
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();

		board.setSeq(1);
		board.setTitle("테스트 제목..");
		board.setWriter("테스터");
		board.setContent("테스트 내용......");
		board.setCreateDate(new Date());
		board.setCnt(0);

		return board;
	}

	@GetMapping("/getBoardList")
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> list = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("테스트 제목..");
			board.setWriter("테스터");
			board.setContent("테스트 내용......");
			board.setCreateDate(new Date());
			board.setCnt(0);

			list.add(board);
		}
		return list;
	}
}
