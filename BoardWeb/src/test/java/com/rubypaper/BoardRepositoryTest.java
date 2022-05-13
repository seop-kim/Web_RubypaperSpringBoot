package com.rubypaper;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Member;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void 테스트데이터입력() {
        Member member1 = new Member();
        member1.setId("templates.member");
        member1.setPassword("member123");
        member1.setName("둘리");
        member1.setRole(Role.ROLE_MEMBER);
        member1.setEnabled(true);
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setId("admin");
        member2.setPassword("admin123");
        member2.setName("도우너");
        member2.setRole(Role.ROLE_ADMIN);
        member2.setEnabled(true);
        memberRepo.save(member2);

        for (int i = 1; i <= 13; i++) {
            Board board = new Board();
            board.setMember(member1);
            board.setTitle(member1.getName() + " 가 등록한 게시글 " + i);
            board.setContent(member1.getName() + " 가 등록한 게시글 " + i);
            boardRepo.save(board);
        }

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setMember(member2);
            board.setTitle(member2.getName() + " 가 등록한 게시글 " + i);
            board.setContent(member2.getName() + " 가 등록한 게시글 " + i);
            boardRepo.save(board);
        }
    }

    @Test
    public void 게시글데이터출력() {
        Board board = boardRepo.findById(1L).get();

        SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");

        System.out.println("[ " + board.getSeq() + "번 게시글 상세 정보 ]");
        System.out.println("제목 : \t" + board.getTitle());
        System.out.println("저자 : \t" + board.getMember().getName());
        System.out.println("내용 : \t" + board.getContent());
        System.out.println("일자 : \t" + simple.format(board.getCreateDate()));
        System.out.println("조회 : \t" + board.getCnt());
    }

    @Test
    public void 회원으로게시글조회() {
        Member member = memberRepo.findById("templates.member").get();

        for (int i = 0; i < member.getBoardList().size(); i++) {
            System.out.println("- " + member.getBoardList().get(i).toString());
        }
    }

    @Test
    public void 게시글수정() {
        Board findBoard = boardRepo.findById(1L).get();

        findBoard.setTitle("수정한 게시글");
        findBoard.setContent("수정한 게시글");
        boardRepo.save(findBoard);
    }

    @Test
    public void 게시글작성() {
        Board board = new Board();

        board.setTitle("태섭 테스트");
        board.setMember(memberRepo.findById("member").get());
        board.setContent("태섭 테스트 내용");

        boardRepo.save(board);
    }

}

