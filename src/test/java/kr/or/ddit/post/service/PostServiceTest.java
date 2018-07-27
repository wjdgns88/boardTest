package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostServiceTest {
	
	private PostServiceInf postService;

	@Before
	public void setup(){
		postService = new PostService();
	}
	
	@Test
	public void searchPostTest() {
		/***Given***/
		

		/***When***/
		List<PostVo> postList = postService.searchPost(1);
		for(PostVo vo : postList){
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(1, postList.size());
	}
	
	@Test
	public void getPostPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("boardId", 2);
		
		/***When***/
		Map<String, Object> resultMap = postService.getPostPageList(map);

		List<PostVo> pageList = (List<PostVo>) resultMap.get("pageList");

		int totCnt = (int) resultMap.get("totCnt");

		/***Then***/
		assertEquals(1, pageList.size());
		assertEquals(1, totCnt); 
	}

	@Test
	public void selectPost(){
		/***Given***/
		

		/***When***/
		PostVo postVo = postService.selectPost(2);
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
		int cnt = postService.insertPost(postVo);
		/***Then***/
		assertEquals(cnt, 1);

	}
	
	
	
}
