package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceInf {

	@Override
	public List<PostVo> searchPost(int board_id) {
		PostDaoInf postDao = new PostDao();
		return postDao.searchPost(board_id);
	}

	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {
		PostDaoInf postDao = new PostDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);
		
		int totCnt = postDao.getPostTotCnt(map.get("boardId"));
		resultMap.put("totCnt", totCnt);
		
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavai(page, pageSize, totCnt, map.get("boardId")));
		return resultMap;
	}
	
	/**
	* Method : makePageNavai
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC01
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자 생성
	*/
	private String makePageNavai(int page, int pageSize, int totCnt,int boardId){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		pageNaviStr.append("<li><a href=\"/postList?page=1"+ "&pageSize=" + pageSize + "&boardId=" + boardId + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">≪</span></a></li>");
		pageNaviStr.append("<li><a href=\"/postList?page=" + prevPage + "&pageSize=" + pageSize + "&boardId=" + boardId + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">＜</span></a></li>");
		
		for(int i = 1; i <= cnt; i++){
			//studentList?page=1&pageSize=10
			String activeClass ="";
			if(i==page)
				activeClass = "class=\"active\"";
			
			pageNaviStr.append("<li "+activeClass + "><a href=\"/postList?page="+i+"&pageSize=" + pageSize + "&boardId=" + boardId + "\">"+i+"</a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/postList?page=" + nextPage + "&pageSize=" + pageSize + "&boardId=" + boardId + "\" aria-label=\"Next\"><span aria-hidden=\"true\">＞</span></a></li>");
		pageNaviStr.append("<li><a href=\"/postList?page=" + cnt + "&pageSize=" + pageSize + "&boardId=" + boardId + "\" aria-label=\"Next\"><span aria-hidden=\"true\">≫</span></a></li>");
		
		
		return pageNaviStr.toString();
	}

	@Override
	public PostVo selectPost(int post_id) {
		PostDaoInf postDao = new PostDao();
		return postDao.selectPost(post_id);
	}

	@Override
	public int insertPost(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.insertPost(postVo);
	}

	@Override
	public int postUpdate(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.postUpdate(postVo);
	}

	@Override
	public int postdelete(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.postdelete(postVo);
	}

	@Override
	public int insertPostReply(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.insertPostReply(postVo);
	}

}
