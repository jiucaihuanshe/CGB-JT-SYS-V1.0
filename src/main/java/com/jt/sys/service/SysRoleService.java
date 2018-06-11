package com.jt.sys.service;
/**
 * 创建角色Service接口
 */
import java.util.List;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysRole;

public interface SysRoleService {
	List<SysRole> findPageObjects();
	int insertObject(SysRole entity);
	int updateObject(SysRole entity);
	SysRole findObjectById(Integer id);
	int deleteObject(String ids);
	
	List<SysRole> findPageObject(String name);
	/**
	 * @param pageCurrent 当前页面（来自Controller,Controller来自点击上一页，下一页出现的页面，客户端）
	 * @param name 按名字搜索时输入的参数。
	 * @return
	 */
	PageObject<SysRole> findPageObject(Integer pageCurrent,String name);
	
	List<CheckBox> findObjects();
}
