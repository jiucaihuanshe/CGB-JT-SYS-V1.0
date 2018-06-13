package com.jt.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService{
	@Autowired
	private SysMenuDao menuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		return menuDao.findObjects();
	}

}
