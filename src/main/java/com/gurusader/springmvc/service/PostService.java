package com.gurusader.springmvc.service;

import java.util.List;

import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.utility.PageCriteria;

public interface PostService {
	List<PostVo> getAllPostList(PageCriteria pageCriteria);
	int countAllPosts();

	List<PostVo> getSearchPostList(PageCriteria pageCriteria);
	int countSearchPosts(PageCriteria pageCriteria);

	PostVo getPost(int postNo);

	int writePost(PostVo postVo);
	int revisePost(PostVo postVo);
	int deletePost(int postNo);
}
