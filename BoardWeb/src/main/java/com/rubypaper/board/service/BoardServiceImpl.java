package com.rubypaper.board.service;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;


    @Override // 게시글 작성
    public void insertBoard(Board board) {
        boardRepo.save(board);
    }

    @Override // 게시글 수정
    public void updateBoard(Board board) {
        Board findBoard = boardRepo.findById(board.getSeq()).get();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override // 게시글 삭제
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }

    @Override // 게시글 조회
    public Board getBoard(Board board) {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override // 게시글 목록
    public Page<Board> getBoardList() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
        Page<Board> boardList = boardRepo.getBoardList(pageable);
        return boardList;
    }
}
