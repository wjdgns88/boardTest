package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {

	SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.selectAllBoard");
		session.close();

		return boardList;
	}

	@Override
	public int insertBoard(BoardVo board) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertBoard", board);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int boardUpdate(BoardVo board) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("board.boardUpdate", board);
		session.commit();
		session.close();
		return cnt;
	}

}
