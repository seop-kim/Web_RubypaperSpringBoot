package com.rubypaper;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.DynamicBoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery() {
        String searchCondition = "CONTENT";
        String searchKeyword = "Content";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;

        if (searchCondition.equals("TITLE")) {
            builder.and(qBoard.title.like("%" + searchKeyword + "%"));
        } else if (searchCondition.equals("CONTENT")) {
            builder.and(qBoard.content.like("%" + searchKeyword + "%"));
        }

        Pageable paging = PageRequest.of(0, 5);

        Page<Board> boardList = boardRepo.findAll(builder, paging);
        System.out.println("=== Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
            
        }
    }
}
