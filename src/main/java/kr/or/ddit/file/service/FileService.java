package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

public class FileService implements FileServiceInf {

	@Override
	public List<FileVo> selectFile(int post_id) {
		FileDaoInf fileDao = new FileDao();
		return fileDao.selectFile(post_id);
	}

	@Override
	public int insertFile(FileVo fileVo) {
		FileDaoInf fileDao = new FileDao();
		return fileDao.insertFile(fileVo);
	}

	@Override
	public int updateFile(FileVo fileVo) {
		FileDaoInf fileDao = new FileDao();
		return fileDao.updateFile(fileVo);
	}
	

}
