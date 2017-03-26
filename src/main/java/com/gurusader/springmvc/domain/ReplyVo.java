package com.gurusader.springmvc.domain;

import java.util.Date;

public class ReplyVo {
	private int replyNo;
	private int postNo;
	private String replyText;
	private String replyWriter;
	private Date replyRegDate;
	private Date replyRevDate;

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public Date getReplyRegDate() {
		return replyRegDate;
	}

	public void setReplyRegDate(Date replyRegDate) {
		this.replyRegDate = replyRegDate;
	}

	public Date getReplyRevDate() {
		return replyRevDate;
	}

	public void setReplyRevDate(Date replyRevDate) {
		this.replyRevDate = replyRevDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyVo [replyNo=");
		builder.append(replyNo);
		builder.append(", postNo=");
		builder.append(postNo);
		builder.append(", replyText=");
		builder.append(replyText);
		builder.append(", replyWriter=");
		builder.append(replyWriter);
		builder.append(", replyRegDate=");
		builder.append(replyRegDate);
		builder.append(", replyRevDate=");
		builder.append(replyRevDate);
		builder.append("]");
		return builder.toString();
	}
}
