package com.gurusader.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.persistence.PostDao;

@Service
public class PostServiceImplement implements PostService {
	@Inject
	private PostDao postDao;

	@Override
	public List<PostVo> getPostList(PageCriteria pageCriteria) {
		return postDao.getPostList(pageCriteria);
	}

	@Override
	public List<PostVo> getSearchList(PageCriteria pageCriteria) {
		return postDao.getSearchList(pageCriteria);
	}

	@Override
	public int writePost(PostVo postVo) {
		return postDao.writePost(postVo);
	}

	@Override
	public PostVo getPost(int postNo) {
		return postDao.getPost(postNo);
	}

	@Override
	public int revisePost(PostVo postVo) {
		return postDao.revisePost(postVo);
	}

	@Override
	public int deletePost(int postNo) {
		return postDao.deletePost(postNo);
	}

	@Override
	public int countTotalPosts() {
		return postDao.countTotalPosts();
	}

	@Override
	public int countTotalSearch(PageCriteria pageCriteria) {
		return postDao.countTotalSearch(pageCriteria);
	}
}
