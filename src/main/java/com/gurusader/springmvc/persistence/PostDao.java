package com.gurusader.springmvc.persistence;

import java.util.List;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PostVo;

public interface PostDao {
	List<PostVo> getPostList(PageCriteria pageCriteria);
	int writePost(PostVo postVo);
	PostVo getPost(int poNo);
	int revisePost(PostVo postVo);
	int deletePost(int poNo);
}
