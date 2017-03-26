package com.gurusader.springmvc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class ReplyDaoTest {
	@Inject
	private ReplyDao replyDao;

	@Test
	public void testGetAllReplyList() {
		List<ReplyVo> replyList = replyDao.getAllReplyList(1, new PageCriteria());
		for (ReplyVo replyVo : replyList) {
			System.out.println(replyVo);
		}
	}

	@Test
	public void testWriteReply() {
		ReplyVo replyVo = new ReplyVo();
		replyVo.setPostNo(1);
		replyVo.setReplyText("댓글01");
		replyVo.setReplyWriter("작성자01");
		replyDao.writeReply(replyVo);
	}

	@Test
	public void testReviseReply() {
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReplyNo(1);
		replyVo.setPostNo(1);
		replyVo.setReplyText("수정된 댓글");
		replyDao.reviseReply(replyVo);
	}

	@Test
	public void testDeleteReply() {
		replyDao.deleteReply(1);
	}
}
