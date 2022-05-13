package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rubypaper.domain.Board;

@SessionAttributes("member")
@Controller
public class BoardController {

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    @Autowired
    private BoardService boardService;

    // Thymeleaf
    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Hello 타임리프.^^");
    }


    // JSP

    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }


    @RequestMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute("member") Member member, Board board) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @RequestMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member, Board board) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @RequestMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
        if (member.getId() == null) {
            return "redirect:login";
        } // 로그인 여부 체크

        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

}
