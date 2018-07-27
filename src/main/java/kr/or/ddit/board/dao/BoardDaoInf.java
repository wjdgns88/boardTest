package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	
	/**
	* Method : selectAllBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC01
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 정보를 조회
	*/
	List<BoardVo> selectAllBoard();
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC01
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : 게시판 추가
	*/
	int insertBoard(BoardVo board);
	
	/**
	* Method : boardUpdate
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC01
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : 게시판 업데이트
	*/
	int boardUpdate(BoardVo board);
}
