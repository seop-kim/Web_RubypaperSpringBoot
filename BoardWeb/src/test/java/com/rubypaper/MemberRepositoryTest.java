package com.rubypaper;

import com.rubypaper.board.domain.Member;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {


    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private PasswordEncoder encoder;


    @Test
    public void 멤버조회() {
        Iterable<Member> members = memberRepo.findAll();

        for (Member member : members) {
            System.out.println(member.toString());
        }
    }

    @Test
    public void 멤버비번수정_암호화() {
        String 멤버아이디 = "admin";
        String 변경비번 = "admin123";

        Member updateMember = memberRepo.findById(멤버아이디).get();
        updateMember.setPassword(encoder.encode(변경비번));
        memberRepo.save(updateMember);

    }
}