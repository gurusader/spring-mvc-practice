package com.gurusader.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PageMaker;
import com.gurusader.springmvc.domain.ReplyVo;
import com.gurusader.springmvc.service.ReplyService;

@RestController
@RequestMapping("reply/")
public class ReplyController {
	@Inject
	private ReplyService replyService;

	@RequestMapping(value = "getAllReplyList/{postNo}/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllReplyList(@PathVariable int postNo, @PathVariable int pageNo) {
		Map<String, Object> resultMap = new HashMap<>();

		PageCriteria pageCriteria = new PageCriteria(pageNo);
		resultMap.put("replyVoList", replyService.getAllReplyList(postNo, pageCriteria));
		resultMap.put("pageMaker", new PageMaker(pageCriteria, replyService.countAllReplies(postNo)));

		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}

	@RequestMapping(value = "writeReply", method = RequestMethod.POST)
	public ResponseEntity<String> writeReply(@RequestBody ReplyVo replyVo) {
		replyService.writeReply(replyVo);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	@RequestMapping(value = "reviseReply", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> reviseReply(@RequestBody ReplyVo replyVo) {
		replyService.reviseReply(replyVo);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
}
