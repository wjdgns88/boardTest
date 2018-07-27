package kr.or.ddit.tag.service;

import java.util.List;

import kr.or.ddit.tag.dao.TagDao;
import kr.or.ddit.tag.dao.TagDaoInf;
import kr.or.ddit.tag.model.TagVo;

public class TagService implements TagServiceInf {

	@Override
	public List<TagVo> selectTag(int post_id) {
		TagDaoInf tagDao = new TagDao();
		return tagDao.selectTag(post_id);
	}

	@Override
	public int insertTag(TagVo tag) {
		TagDaoInf tagDao = new TagDao();
		return tagDao.insertTag(tag);
	}

	@Override
	public int deleteTag(int tag_id) {
		TagDaoInf tagDao = new TagDao();
		return tagDao.deleteTag(tag_id);
	}

}
