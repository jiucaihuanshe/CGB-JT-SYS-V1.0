package com.jt.common.vo;
/**
 * 定义一个值对象，用于封装zTree上的节点信息。
 * 不写这个类可以吗？
 * 可以(借助SysMenu或map都可以封装)
 */
public class Node {
	private Integer id;
	private Integer parentId;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
