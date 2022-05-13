package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void insertBoard() {
        Board board = new Board();
        board.setTitle("test2");
        board.setWriter("Tester2");
        board.setContent("Content is Good?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }
}
