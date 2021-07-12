package com.koreait.test1;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfiguration;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})
public class BoardTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void insertTest() {
	
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBWriter("tester");
		boardDTO.setBTitle("InsertTitle");
		boardDTO.setBContent("test입니다.");
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.insertBoard(boardDTO.getBWriter(),boardDTO.getBTitle(),boardDTO.getBContent());
		
		assertEquals("삽입 실패", 1, count);
	}
	
	@Test
	public void selectTest() {
	
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		BoardDTO boardDTO = boardDAO.selectBybIdx(9999);
		
		assertEquals("조회 실패", boardDTO, boardDTO);
	}
	
	@Test
	public void updateTest() {
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBTitle("변경공지사항제목");
		boardDTO.setBContent("변경공지사항내용");
		boardDTO.setBIdx(9999);
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.updateBoard(boardDTO.getBTitle(), boardDTO.getBContent(), boardDTO.getBIdx());
		
		assertEquals("수정 실패", 1, count);
	}

	@Test
	public void deleteTest() {
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.deleteBoard(9999);
		
		assertEquals("삭제 실패", 1, count);
	}
	
}
