package com.gurusader.springmvc.service;

import java.util.List;

import com.gurusader.springmvc.domain.PostVo;

public interface PostService {
	int writePost(PostVo postVo);
	PostVo getPost(int postNo);
	List<PostVo> getPostList();
	int revisePost(PostVo postVo);
	int deletePost(int postNo);
}
