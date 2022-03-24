package com.rubypaper;

import java.util.Date;

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

	public void boardList() {
		try {
			Board searchBoard = em.find(Board.class, 1L);
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
}
