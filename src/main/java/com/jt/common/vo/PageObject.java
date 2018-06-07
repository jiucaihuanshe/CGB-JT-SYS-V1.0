package com.jt.common.vo;

import java.util.List;

import com.jt.sys.pojo.SysRole;

/**
 * VO：Value Object(值对象)
 * 借助此对象封装当前页数据以及分页信息
 */
public class PageObject {
	/**当前页记录*/
	private List<SysRole> records;
	/**总页数（计算）*/
	private int pageCount;
	/**总记录数（从数据库获取）*/
	private int rowCount;
	/**当前页的页面（计算）*/
	private int pageCurrent;
	public List<SysRole> getRecords() {
		return records;
	}
	public void setRecords(List<SysRole> records) {
		this.records = records;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
}
