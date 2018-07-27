package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf boardDao;
	
	@Before
	public void setup(){
		boardDao = new BoardDao();
	}

	@Test
	public void selectAllBoardTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo> boardList = boardDao.selectAllBoard();
		for(BoardVo vo : boardList){
			System.out.println(vo);
		}
		/***Then***/
		assertEquals(2, boardList.size());

	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setId(2);
		boardVo.setBoard_dt(new Date());
		boardVo.setBoard_name("가나다라");
		boardVo.setBoard_delet('1');
		
		
		/***When***/
		int cnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void boardUpdate(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setId(3);
		boardVo.setBoard_delet('0');
		boardVo.setBoard_dt(new Date());
		boardVo.setBoard_id(78);
		boardVo.setBoard_name("수정 테스트");

		/***When***/
		int cnt = boardDao.boardUpdate(boardVo);
		/***Then***/
		assertEquals(1, cnt);
	}
}
