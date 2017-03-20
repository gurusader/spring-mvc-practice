package com.gurusader.springmvc.persistence;

import java.util.List;

import com.gurusader.springmvc.domain.PostVo;

public interface PostDao {
	int writePost(PostVo postVo);
	PostVo getPost(int poNo);
	List<PostVo> getPostList();
	int revisePost(PostVo postVo);
	int deletePost(int poNo);
}
