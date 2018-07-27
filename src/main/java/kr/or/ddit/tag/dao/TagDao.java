package kr.or.ddit.tag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.tag.model.TagVo;

public class TagDao implements TagDaoInf {

	SqlSessionFactory sessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<TagVo> selectTag(int post_id) {
		SqlSession session = sessionFactory.openSession();
		List<TagVo> tagList = session.selectList("tag.selectTag", post_id);
		session.close();
		
		return tagList;
	}

	@Override
	public int insertTag(TagVo tag) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.insert("tag.insertTag", tag);
		session.commit();
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteTag(int tag_id) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.update("tag.deleteTag", tag_id);
		session.commit();
		session.close();

		return cnt;
	}

}
