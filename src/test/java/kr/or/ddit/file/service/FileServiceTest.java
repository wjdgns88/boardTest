package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

import org.junit.Before;
import org.junit.Test;

public class FileServiceTest {
	
	FileServiceInf fileService;
	
	@Before
	public void setup(){
		fileService = new FileService();
	}

	@Test
	public void selectFileTest() {
		/***Given***/
		

		/***When***/
		List<FileVo> fileList = fileService.selectFile(2);
		/***Then***/
		assertEquals(1, fileList.size());

	}

}
