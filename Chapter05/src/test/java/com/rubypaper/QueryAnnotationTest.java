package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {

    @Autowired
    private BoardRepository boardRepo;
    /*
    @Test
    public void 쿼리어노테이션테스트1() {
        List<Board> boardList = boardRepo.queryAnnotationTest1("Title 10");

        System.out.println("=== Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void 쿼리어노테이션테스트2() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest2("Title 10");

        System.out.println("=== Result ===");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }

    @Test
    public void 쿼리어노테이션테스트3() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest3("Title 10");

        System.out.println("=== Result ===");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }

    @Test
    public void testQueryAnnotationTest4() {
        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepo.queryAnnotationTest4(paging);

        System.out.println("=== Result ===");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }

}

     */
}
