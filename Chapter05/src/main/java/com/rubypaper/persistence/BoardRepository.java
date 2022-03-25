package com.rubypaper.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    // 제목에서 검색
    List<Board> findByTitle(String searchKeyword);

    // 게시물에서 특정 키워드가 포함된 게시물 검색 ( Containing 키워드를 사용하면 Like 문이 사용된다. )
    List<Board> findByContentContaining(String searchKeyword);

    // 여러조건을 검색하기 ( 제목과 게시글에서 검색하는 조건 )
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
}
