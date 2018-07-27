package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

public interface FileDaoInf {
	
	/**
	* Method : selectFile
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : user
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 번호로 파일 조회
	*/
	List<FileVo> selectFile(int post_id);
	
	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : user
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 추가
	*/
	int insertFile(FileVo fileVo);
	
	/**
	* Method : updateFile
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : user
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 게시글 수정시 파일 추가
	*/
	int updateFile(FileVo fileVo);
}
