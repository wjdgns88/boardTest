package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostDaoTest {
	
	private PostDaoInf postDao;

	@Before
	public void setup(){
		postDao = new PostDao();
	}
	
	@Test
	public void searchPostTest() {
		/***Given***/
		

		/***When***/
		List<PostVo> postList = postDao.searchPost(1);
		for(PostVo vo : postList){
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(2, postList.size());
	}
	
	@Test
	public void getPostPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 2);
		map.put("boardId", 1);

		/***When***/
		List<PostVo> postList = postDao.getPostPageList(map);

		/***Then***/
		assertEquals(2, postList.size());

	}
	
	@Test
	public void getPostTotCntTest(){
		
		/***Given***/
		

		/***When***/
		int cnt = postDao.getPostTotCnt(1);

		/***Then***/
		assertEquals(2, cnt);
		
	}

	@Test
	public void selectPost(){
		/***Given***/
		

		/***When***/
		PostVo postVo = postDao.selectPost(2);
		System.out.println(postVo);
		/***Then***/
		assertEquals("test1", postVo.getPost_title());
	}
	
	
	@Test
	public void insertPost(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoard_id(1);
		postVo.setId(2);
		postVo.setPost_content("글 내용");
		postVo.setPost_dt(new Date());
		postVo.setPost_title("글 제목");
		postVo.setPost_delet('1');
		
		/***When***/
		int cnt = postDao.insertPost(postVo);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	@Test
	public void postUpdate(){
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setPost_id(1);
		postVo.setPost_title("게시글 수정");
		postVo.setPost_content("게시글 수정입니다.");
		postVo.setPost_dt(new Date());

		/***When***/
		int cnt = postDao.postUpdate(postVo);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	
	
	
}
