package com.rubypaper.board.service;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.QBoard;
import com.rubypaper.board.domain.Search;
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
    public Page<Board> getBoardList(Search search) {
        BooleanBuilder builder = new BooleanBuilder();
        QBoard qBoard = QBoard.board;
        /**
         * QBoard 를 읽어오지 못하는 문제가 발생할 경우
         * Project Structure -> modules -> BoardWeb 프로젝트 -> main 밑에 있는 querydsl 폴더 우클릭 Sources 클릭하여 적용 후 Apply
         */

        if (search.getSearchCondition().equals("TITLE")) {
            builder.and(qBoard.title.like("%" + search.getSearchKeyword() + "%"));

        } else if (search.getSearchCondition().equals("CONTENT")) {
            builder.and(qBoard.content.like("%" + search.getSearchKeyword() + "%"));
        }

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");

        return boardRepo.findAll(builder, pageable);

        // Page<Board> boardList = boardRepo.getBoardList(pageable);
        // return boardList;
    }
}
