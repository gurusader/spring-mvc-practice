package com.gurusader.springmvc.service;

import java.util.List;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PostVo;

public interface PostService {
	List<PostVo> getPostList(PageCriteria pageCriteria);
	int writePost(PostVo postVo);
	PostVo getPost(int postNo);
	int revisePost(PostVo postVo);
	int deletePost(int postNo);
	int countTotalPosts();
}
