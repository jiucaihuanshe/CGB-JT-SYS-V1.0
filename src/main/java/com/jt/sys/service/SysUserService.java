package com.jt.sys.service;

import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysUser;

public interface SysUserService {
	PageObject<SysUser> findUserObject(String username,Integer pageCurrent);
	/**禁用和启用*/
	int validById(Integer id,Integer valid,String modifiedUser);

	int insertObject(SysUser entity,String roleIds);
	
	Map<String,Object> findObjectById(Integer id);
}
