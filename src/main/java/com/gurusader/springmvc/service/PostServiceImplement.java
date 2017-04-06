package com.gurusader.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.persistence.PostDao;
import com.gurusader.springmvc.utility.PageCriteria;

@Service
public class PostServiceImplement implements PostService {
	@Inject
	private PostDao postDao;

	@Override
	public List<PostVo> getAllPostList(PageCriteria pageCriteria) {
		return postDao.getAllPostList(pageCriteria);
	}

	@Override
	public int countAllPosts() {
		return postDao.countAllPosts();
	}

	@Override
	public List<PostVo> getSearchPostList(PageCriteria pageCriteria) {
		return postDao.getSearchPostList(pageCriteria);
	}

	@Override
	public int countSearchPosts(PageCriteria pageCriteria) {
		return postDao.countSearchPosts(pageCriteria);
	}

	@Override
	public PostVo getPost(int postNo) {
		return postDao.getPost(postNo);
	}

	@Override
	public int writePost(PostVo postVo) {
		return postDao.writePost(postVo);
	}

	@Override
	public int revisePost(PostVo postVo) {
		return postDao.revisePost(postVo);
	}

	@Override
	public int deletePost(int postNo) {
		return postDao.deletePost(postNo);
	}
}
