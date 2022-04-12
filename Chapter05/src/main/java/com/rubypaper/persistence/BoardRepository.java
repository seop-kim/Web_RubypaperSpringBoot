package com.rubypaper.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    // 제목에서 검색
    List<Board> findByTitle(String searchKeyword);

    // 게시물에서 특정 키워드가 포함된 게시물 검색 ( Containing 키워드를 사용하면 Like 문이 사용된다. )
    List<Board> findByContentContaining(String searchKeyword);

    // 여러조건을 검색하기 ( 제목과 게시글에서 검색하는 조건 )
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // 데이터 정렬
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    // 페이징과 정렬
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);

    @Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query(value = "SELECT seq, title, writer, create_date " + "FROM board WHERE title LIKE '%'||?1||'%' " + "ORDER BY seq DESC", nativeQuery = true)
    List<Object[]> queryAnnotationTest3(String searchKeyword);

    @Query("SELECT b FROM Board b ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest4(Pageable paging);
}
