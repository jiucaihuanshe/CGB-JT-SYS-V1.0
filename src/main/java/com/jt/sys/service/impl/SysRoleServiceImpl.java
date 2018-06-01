package com.jt.sys.service.impl;
/**
 * 创建角色Service实现类
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Override
	public List<SysRole> findPageObjects() {
		List<SysRole> list = sysRoleDao.findPageObjects();
		return list;
	}
	@Override
	public int insertObject(SysRole entity) {
		int insert = sysRoleDao.insertObject(entity);
		return insert;
	}
	@Override
	public int updateObject(SysRole entity) {
		int update = sysRoleDao.updateObject(entity);
		return update;
	}
	@Override
	public SysRole findObjectById(Integer id) {
		SysRole entity=sysRoleDao.findObjectById(id);
		return entity;
	}
	@Override
	public int deleteObject(String[] ids) {
		int rows = sysRoleDao.deleteObject(ids);
		return rows;
	}

}
