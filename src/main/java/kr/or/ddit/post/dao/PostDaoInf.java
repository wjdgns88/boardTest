package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

public interface PostDaoInf {
	
	/**
	* Method : searchPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC01
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시판 아이디로 게시글 조회
	*/
	List<PostVo> searchPost(int board_id);
	
	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC01
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이징 리스트 조회
	*/
	List<PostVo> getPostPageList(Map<String, Integer> map);
	
	/**
	* Method : getPostTotCnt
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC01
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 게시판 아이디로 게시글 조회
	*/
	int getPostTotCnt(int boardId);
	
	
	/**
	* Method : selectPost
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : user
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 번호로 게시글 조회
	*/
	PostVo selectPost(int post_id);
	
	/**
	* Method : insertPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : user
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	int insertPost(PostVo postVo);
	
	
	/**
	* Method : postUpdate
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : user
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 업데이트
	*/

	int postUpdate(PostVo postVo);
	
	/**
	 * Method : postUpdate
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : user
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 삭제 업데이트
	 */
	int postdelete(PostVo postVo);
	
	/**
	* Method : insertPostReply
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : user
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 생성
	*/
	int insertPostReply(PostVo postVo);
	
	
	
	
	
}
