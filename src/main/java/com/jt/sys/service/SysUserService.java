package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysUser;

public interface SysUserService {
	PageObject findUserObject(String username,Integer pageCurrent);
	SysUser findUserById(Integer id);
	int saveObject(SysUser entity);
	int updateObject(SysUser entity);
	int deleteObject(Integer id);
}
