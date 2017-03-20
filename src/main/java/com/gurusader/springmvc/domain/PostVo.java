package com.gurusader.springmvc.domain;

import java.util.Date;

public class PostVo {
	private int postNo;
	private String postTitle;
	private String postText;
	private String postWriter;
	private Date postRegDate;
	private Date postRevDate;
	private int postViewCnt;

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}

	public Date getPostRegDate() {
		return postRegDate;
	}

	public void setPostRegDate(Date postRegDate) {
		this.postRegDate = postRegDate;
	}

	public Date getPostRevDate() {
		return postRevDate;
	}

	public void setPostRevDate(Date postRevDate) {
		this.postRevDate = postRevDate;
	}

	public int getPostViewCnt() {
		return postViewCnt;
	}

	public void setPostViewCnt(int postViewCount) {
		this.postViewCnt = postViewCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostVo [postNo=");
		builder.append(postNo);
		builder.append(", postTitle=");
		builder.append(postTitle);
		builder.append(", postText=");
		builder.append(postText);
		builder.append(", postWriter=");
		builder.append(postWriter);
		builder.append(", postRegDate=");
		builder.append(postRegDate);
		builder.append(", postRevDate=");
		builder.append(postRevDate);
		builder.append(", postViewCnt=");
		builder.append(postViewCnt);
		builder.append("]");
		return builder.toString();
	}
}
