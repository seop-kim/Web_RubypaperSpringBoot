package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
	EntityManagerFactory emf;
	EntityManager em;

	public static void main(String[] args) {
		JPAClient jc = new JPAClient();
		// entity 생성
		jc.entityCreate();

		jc.boardList();

		// entity 종료
		jc.entityKill();
	}

	public void delBoard() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Board board = em.find(Board.class, 1L);
		board.setSeq(1L);

		board.setSeq(1L);
		em.remove(board);

		tx.commit();
	}

	public void boardList() {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Board board = new Board();
			String jpql = "SELECT B FROM Board B ORDER BY B.seq DESC";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();

			for (Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}

			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
	}

	public void updateBoard() {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Board board = em.find(Board.class, 1L);
			board.setTitle("update title");

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void boardInsert() {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Board board = new Board();
			board.setTitle("JPA title");
			board.setWriter("admin");
			board.setContent("JPA content is good");
			board.setCreateDate(new Date());
			board.setCnt(0L);

			em.persist(board);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}
	}

	public void getBoard() {
		try {
			Board searchBoard = em.find(Board.class, 2L);
			System.out.println("---> " + searchBoard.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void entityCreate() {
		// EntityManager 생성
		emf = Persistence.createEntityManagerFactory("Chapter04");
		em = emf.createEntityManager();
	}

	public void entityKill() {
		em.close();
		emf.close();
	}

	public void sleep(int i) {

		i = i * 1000;

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
