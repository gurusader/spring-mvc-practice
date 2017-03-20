package com.gurusader.springmvc.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gurusader.springmvc.domain.PostVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class PostDaoTest {
	@Inject
	private PostDao postDao;

	@Test
	public void testWritePost() {
		PostVo postVo = new PostVo();
		postVo.setPostTitle("제목");
		postVo.setPostText("내용");
		postVo.setPostWriter("작성자");
		postDao.writePost(postVo);
	}

	@Test
	public void testGetPost() {
		System.out.println(postDao.getPost(1));
	}

	@Test
	public void testRevisePost() {
		PostVo postVo = new PostVo();
		postVo.setPostNo(1);
		postVo.setPostTitle("수정된 제목");
		postVo.setPostText("수정된 내용");
		postDao.revisePost(postVo);
	}

	@Test
	public void testDeletePost() {
		postDao.deletePost(1);
	}
}
