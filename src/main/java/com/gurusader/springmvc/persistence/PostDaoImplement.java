package com.gurusader.springmvc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PostVo;

@Repository
public class PostDaoImplement implements PostDao {
	@Value("#{mybatis['namespace.base']}" + "#{mybatis['namespace.post']}")
	private String namespace;

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<PostVo> getPostList(PageCriteria pageCriteria) {
		return sqlSession.selectList(namespace + ".getPostList", pageCriteria);
	}

	@Override
	public int writePost(PostVo postVo) {
		return sqlSession.insert(namespace + ".writePost", postVo);
	}

	@Override
	public PostVo getPost(int postNo) {
		return sqlSession.selectOne(namespace + ".getPost", postNo);
	}

	@Override
	public int revisePost(PostVo postVo) {
		return sqlSession.update(namespace + ".revisePost", postVo);
	}

	@Override
	public int deletePost(int postNo) {
		return sqlSession.delete(namespace + ".deletePost", postNo);
	}

	@Override
	public int countTotalPosts() {
		return sqlSession.selectOne(namespace + ".countTotalPosts");
	}
}
