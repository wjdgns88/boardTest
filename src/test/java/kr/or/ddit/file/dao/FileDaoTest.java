package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

import org.junit.Before;
import org.junit.Test;

public class FileDaoTest {

	FileDaoInf fileDao;
	
	@Before
	public void setup(){
		fileDao = new FileDao();
	}
	
	@Test
	public void selectFileTest() {
		/***Given***/
		

		/***When***/
		List<FileVo> fileList = fileDao.selectFile(2);
		/***Then***/
		assertEquals(1, fileList.size());

	}
	
	@Test
	public void insertFileTest(){
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("sally.png");
		fileVo.setFile_path("C:\\Users\\user\\Desktop\\img");
		fileVo.setFile_up("sally.png");
		fileVo.setPost_id(1);
		

		/***When***/
		int cnt = fileDao.insertFile(fileVo);
		/***Then***/
		assertEquals(1, cnt);

	}

}
