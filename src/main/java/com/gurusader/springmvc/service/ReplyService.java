package com.gurusader.springmvc.service;

import java.util.List;

import com.gurusader.springmvc.domain.ReplyVo;
import com.gurusader.springmvc.utility.PageCriteria;

public interface ReplyService {
	List<ReplyVo> getAllReplyList(int postNo, PageCriteria pageCriteria);
	int countAllReplies(int postNo);

	int writeReply(ReplyVo replyVo);
	int reviseReply(ReplyVo replyVo);
	int deleteReply(int replyNo);
}
