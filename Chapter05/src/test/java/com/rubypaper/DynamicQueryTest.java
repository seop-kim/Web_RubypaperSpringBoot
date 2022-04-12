package com.rubypaper;


import com.querydsl.core.BooleanBuilder;
import com.rubypaper.persistence.DynamicBoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery() {
        String searchCondition = "TITLE";
        String searchKeyword = "테스트제목 10";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;
    }
}
