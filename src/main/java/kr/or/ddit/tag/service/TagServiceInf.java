package kr.or.ddit.tag.service;

import java.util.List;

import kr.or.ddit.tag.model.TagVo;

public interface TagServiceInf {

	
	/**
	* Method : selectTag
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : user
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시판 번호로 댓글 조회
	*/
	List<TagVo> selectTag(int post_id);
	
	/**
	* Method : insertTag
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : user
	* 변경이력 :
	* @param tag
	* @return
	* Method 설명 : 댓글 추가
	*/
	int insertTag(TagVo tag);
	
	
	/**
	* Method : deleteTag
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : user
	* 변경이력 :
	* @param tag_id
	* @return
	* Method 설명 : 댓글 삭제여부 변경
	*/
	int deleteTag(int tag_id);
}
