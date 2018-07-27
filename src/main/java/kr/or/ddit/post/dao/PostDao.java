package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<PostVo> searchPost(int board_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.searchPost", board_id);
		session.close();
		
		return postList;
	}

	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getPostPageList", map);
		session.close();
		
		return postList;
	}

	@Override
	public int getPostTotCnt(int boardId) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("post.getPostTotCnt", boardId);
		session.close();
		
		return cnt;
	}

	@Override
	public PostVo selectPost(int post_id) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo postVo = session.selectOne("post.selectPost", post_id);
		session.close();
		
		return postVo;
	}

	@Override
	public int insertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int postUpdate(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("post.postUpdate", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int postdelete(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("post.postdelete", postVo);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int insertPostReply(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("post.insertPostReply", postVo);
		session.commit();
		session.close();
		return cnt;
	}
	
	

}
