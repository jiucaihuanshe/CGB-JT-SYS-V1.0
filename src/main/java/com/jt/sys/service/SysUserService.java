package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysUser;

public interface SysUserService {
	PageObject<SysUser> findUserObject(String username,Integer pageCurrent);
	/**禁用和启用*/
	int validById(Integer id,Integer valid,String modifiedUser);

}
