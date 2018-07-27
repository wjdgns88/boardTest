package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FileDao implements FileDaoInf {
	
	SqlSessionFactory sessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<FileVo> selectFile(int post_id) {
		SqlSession session = sessionFactory.openSession();
		List<FileVo> fileList = session.selectList("file.selectFile",post_id);
		session.close();
		
		return fileList;
	}

	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.insert("file.insertFile", fileVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updateFile(FileVo fileVo) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.insert("file.updateFile", fileVo);
		session.commit();
		session.close();
		return cnt;
	}
	
}
