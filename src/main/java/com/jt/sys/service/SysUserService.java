package com.jt.sys.service;

import com.jt.common.vo.PageObject;

public interface SysUserService {
	PageObject findUserObject(String username,Integer pageCurrent);
}
