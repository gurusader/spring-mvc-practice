package com.gurusader.springmvc.persistence;

import java.util.List;

import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.utility.PageCriteria;

public interface PostDao {
	List<PostVo> getAllPostList(PageCriteria pageCriteria);
	int countAllPosts();

	List<PostVo> getSearchPostList(PageCriteria pageCriteria);
	int countSearchPosts(PageCriteria pageCriteria);

	PostVo getPost(int poNo);

	int writePost(PostVo postVo);
	int revisePost(PostVo postVo);
	int deletePost(int poNo);
}
