package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void 게시글작성() {
        Board board = new Board();
        board.setTitle("First Title");
        board.setWriter("Tester");
        board.setContent("Content is Good?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }

    @Test
    public void 테스트게시글작성() {
        for (int i = 0; i <= 200; i++) {
            Board board = new Board();
            board.setTitle("Title " + i);
            board.setWriter("Tester " + i);
            board.setContent("Content is Good? " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);

            boardRepo.save(board);
        }
    }

    @Test
    public void 게시글가져오기() {
        Board board = boardRepo.findById(2L).get();
        System.out.println(board.toString());
    }

    @Test
    public void 게시글검색() {
        List<Board> boardList = boardRepo.findByTitle("Title 1");
        System.out.println("=== Search Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void 게시물단어포함검색() {
        List<Board> boardList = boardRepo.findByContentContaining("17");
        System.out.println("=== Search Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void 다중조건검색() { // 제목, 내용
        List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("5", "16");

        System.out.println("=== Search Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void 게시글수정() {
        System.out.println("=== Seq 1, BoardContent ===");
        Board board = boardRepo.findById(1L).get();
        System.out.println("=== BoardContent before Title ===");
        System.out.println(board.toString() + "\n");

        board.setTitle("Title Update");
        boardRepo.save(board);
        System.out.println("=== BoardContent after Title ===");
        board = boardRepo.findById(1L).get();
        System.out.println(board.toString());
    }

    @Test
    public void 게시글삭제() {
        boardRepo.deleteById(1L);
    }

}
