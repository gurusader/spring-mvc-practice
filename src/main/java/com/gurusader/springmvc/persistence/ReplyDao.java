package com.gurusader.springmvc.persistence;

import java.util.List;

import com.gurusader.springmvc.domain.ReplyVo;
import com.gurusader.springmvc.utility.PageCriteria;

public interface ReplyDao {
	List<ReplyVo> getAllReplyList(int postNo, PageCriteria pageCriteria);
	int countAllReplies(int postNo);

	int writeReply(ReplyVo replyVo);
	int reviseReply(ReplyVo replyVo);
	int deleteReply(int replyNo);
}
