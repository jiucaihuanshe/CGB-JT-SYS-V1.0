package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserDao sysUserDao;
	@Override
	public PageObject findUserObject(String username, Integer pageCurrent) {
		//1.获取当前页数据
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUser> list = sysUserDao.findUserObject(username, startIndex, pageSize);
		//2.获取总记录数，计算总页数
		int rowCount = sysUserDao.getRowCount(username);
		int pageCount = rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//3.封装数据
		PageObject pageObject = new PageObject();
		pageObject.setUserrecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}

}
