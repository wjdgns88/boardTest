package kr.or.ddit.tag.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.tag.model.TagVo;

import org.junit.Before;
import org.junit.Test;

public class TagDaoTest {

	private TagDaoInf tagDao;
	
	@Before
	public void setup(){
		tagDao = new TagDao();
	}
	
	@Test
	public void selectTagTest() {
		/***Given***/
		

		/***When***/
		List<TagVo> tagList = tagDao.selectTag(3);
		System.out.println(tagList);
		
		/***Then***/
		assertEquals(3, tagList.size());

	}
	
	@Test
	public void insertTag(){
		/***Given***/
		
		TagVo tag = new TagVo();
		tag.setId(3);
		tag.setTag_content("댓글 추가 입니다");
		tag.setTag_delet('1');
		tag.setTag_dt(new Date());
		tag.setPost_id(2);

		/***When***/
		int cnt = tagDao.insertTag(tag);
		/***Then***/
		assertEquals(cnt, 1);

	}

	
	@Test
	public void deleteTag(){
		/***Given***/
		

		/***When***/
		int cnt = tagDao.deleteTag(3);
		/***Then***/
		assertEquals(cnt, 1);

	}
	
	
	
	
	
	
	
	
	
	
}
