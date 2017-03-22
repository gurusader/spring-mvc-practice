package com.gurusader.springmvc.domain;

public class PageCriteria {
	private static final int DEFAULT_PAGE_NO = 1;
	private static final int DEFAULT_CONTENTS_PER_PAGE = 10;
	private static final int MAX_CONTENTS_PER_PAGE = 100;

	private int currentPageNo;
	private int contentsPerPage;

	public PageCriteria() {
		this(DEFAULT_PAGE_NO, DEFAULT_CONTENTS_PER_PAGE);
	}

	public PageCriteria(int currentPageNo) {
		this(currentPageNo, DEFAULT_CONTENTS_PER_PAGE);
	}

	public PageCriteria(int currentPageNo, int contentsPerPage) {
		setCurrentPageNo(currentPageNo);
		setContentsPerPage(contentsPerPage);
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo <= 0) {
			currentPageNo = DEFAULT_PAGE_NO;
		}

		this.currentPageNo = currentPageNo;
	}

	public int getContentsPerPage() {
		return contentsPerPage;
	}

	public void setContentsPerPage(int contentsPerPage) {
		if (contentsPerPage <= 0 || contentsPerPage > MAX_CONTENTS_PER_PAGE) {
			contentsPerPage = DEFAULT_CONTENTS_PER_PAGE;
		}

		this.contentsPerPage = contentsPerPage;
	}

	public int getFirstContentNo() {
		return (currentPageNo - 1) * contentsPerPage;
	}
}
