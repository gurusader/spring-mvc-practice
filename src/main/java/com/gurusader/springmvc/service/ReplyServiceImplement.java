package com.gurusader.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gurusader.springmvc.domain.ReplyVo;
import com.gurusader.springmvc.persistence.ReplyDao;
import com.gurusader.springmvc.utility.PageCriteria;

@Service
public class ReplyServiceImplement implements ReplyService {
	@Inject
	private ReplyDao replyDao;

	@Override
	public List<ReplyVo> getAllReplyList(int postNo, PageCriteria pageCriteria) {
		return replyDao.getAllReplyList(postNo, pageCriteria);
	}

	@Override
	public int countAllReplies(int postNo) {
		return replyDao.countAllReplies(postNo);
	}

	@Override
	public int writeReply(ReplyVo replyVo) {
		return replyDao.writeReply(replyVo);
	}

	@Override
	public int reviseReply(ReplyVo replyVo) {
		return replyDao.reviseReply(replyVo);
	}

	@Override
	public int deleteReply(int replyNo) {
		return replyDao.deleteReply(replyNo);
	}
}
