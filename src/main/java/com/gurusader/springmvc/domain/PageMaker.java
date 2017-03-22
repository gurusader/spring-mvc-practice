package com.gurusader.springmvc.domain;

public class PageMaker {
	private PageCriteria pageCriteria;
	private int totalContents;
	private int pagesPerPagination;

	private int firstPageNo;
	private int lastPageNo;

	private boolean isPre;
	private boolean isNext;

	public PageMaker(PageCriteria pageCriteria, int totalContents) {
		this.pageCriteria = pageCriteria;
		this.totalContents = totalContents;
		pagesPerPagination = 10;

		calPageNo();
	}

	private void calPageNo() {
		lastPageNo = (int) (Math.ceil((double) pageCriteria.getCurrentPageNo() / pagesPerPagination) * pagesPerPagination);
		firstPageNo = lastPageNo - pagesPerPagination + 1;

		int temporary = (int) (Math.ceil((double) totalContents / pageCriteria.getContentsPerPage()));
		if (lastPageNo > temporary) {
			lastPageNo = temporary;
		}

		isPre = firstPageNo != 1;
		isNext = (lastPageNo * pageCriteria.getContentsPerPage()) < totalContents;
	}

	public PageCriteria getPageCriteria() {
		return pageCriteria;
	}

	public void setPageCriteria(PageCriteria pageCriteria) {
		this.pageCriteria = pageCriteria;
	}

	public int getTotalContents() {
		return totalContents;
	}

	public void setTotalContents(int totalContents) {
		this.totalContents = totalContents;
	}

	public int getPagesPerPagination() {
		return pagesPerPagination;
	}

	public void setPagesPerPagination(int pagesPerPagination) {
		this.pagesPerPagination = pagesPerPagination;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	public boolean isPre() {
		return isPre;
	}

	public void setPre(boolean pre) {
		isPre = pre;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean next) {
		isNext = next;
	}
}
