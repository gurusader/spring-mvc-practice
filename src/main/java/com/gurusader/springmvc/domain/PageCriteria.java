package com.gurusader.springmvc.domain;

public class PageCriteria {
	private int currentPageNo;
	private int contentsPerPage;

	public PageCriteria() {
		this(1, 10);
	}

	public PageCriteria(int currentPageNo) {
		this(currentPageNo, 10);
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
			currentPageNo = 1;
		}

		this.currentPageNo = currentPageNo;
	}

	public int getContentsPerPage() {
		return contentsPerPage;
	}

	public void setContentsPerPage(int contentsPerPage) {
		if (contentsPerPage <= 0 || contentsPerPage > 100) {
			contentsPerPage = 10;
		}

		this.contentsPerPage = contentsPerPage;
	}

	public int getFirstContentNo() {
		return (currentPageNo - 1) * contentsPerPage;
	}
}
