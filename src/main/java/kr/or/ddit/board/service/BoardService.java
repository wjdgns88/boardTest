package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {

	@Override
	public List<BoardVo> selectAllBoard() {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.selectAllBoard();
	}

	@Override
	public int insertBoard(BoardVo board) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.insertBoard(board);
	}

	@Override
	public int boardUpdate(BoardVo board) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.boardUpdate(board);
	}

}
