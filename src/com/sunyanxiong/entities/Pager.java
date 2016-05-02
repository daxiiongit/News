package com.sunyanxiong.entities;

// 分页实体类
public class Pager {

	private int curPage; // 待显示页
	private int perPageRows; // 每页显示记录数
	private int rowCount;// 总记录数
	private int pageCount; // 总页数

	public int getCurPage() {
		return curPage;
	}

	public int getPerPageRows() {
		return perPageRows;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
