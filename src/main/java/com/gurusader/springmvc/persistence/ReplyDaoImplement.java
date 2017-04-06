package com.gurusader.springmvc.persistence;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gurusader.springmvc.domain.ReplyVo;
import com.gurusader.springmvc.utility.PageCriteria;

@Repository
public class ReplyDaoImplement implements ReplyDao {
	@Value("#{mybatis['namespace.base']}" + "#{mybatis['namespace.reply']}")
	private String namespace;

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ReplyVo> getAllReplyList(int postNo, PageCriteria pageCriteria) {
		Map<String, Object> parameters = new Hashtable<>();
		parameters.put("postNo", postNo);
		parameters.put("pageCriteria", pageCriteria);
		return sqlSession.selectList(namespace + ".getAllReplyList", parameters);
	}

	@Override
	public int countAllReplies(int postNo) {
		return sqlSession.selectOne(namespace + ".countAllReplies", postNo);
	}

	@Override
	public int writeReply(ReplyVo replyVo) {
		return sqlSession.insert(namespace + ".writeReply", replyVo);
	}

	@Override
	public int reviseReply(ReplyVo replyVo) {
		return sqlSession.update(namespace + ".reviseReply", replyVo);
	}

	@Override
	public int deleteReply(int replyNo) {
		return sqlSession.delete(namespace + ".deleteReply", replyNo);
	}
}
