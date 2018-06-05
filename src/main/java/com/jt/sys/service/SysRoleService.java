package com.jt.sys.service;
/**
 * 创建角色Service接口
 */
import java.util.List;

import com.jt.sys.pojo.SysRole;

public interface SysRoleService {
	List<SysRole> findPageObjects();
	int insertObject(SysRole entity);
	int updateObject(SysRole entity);
	SysRole findObjectById(Integer id);
	int deleteObject(String ids);
	
	List<SysRole> findPageObject();
}
