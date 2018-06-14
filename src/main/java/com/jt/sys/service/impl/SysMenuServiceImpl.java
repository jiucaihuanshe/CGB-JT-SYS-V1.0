package com.jt.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.Node;
import com.jt.common.vo.SysMenu;
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

	@Override
	public void deleteObject(Integer menuId) {
		//判断参数的有效性
		if(menuId==null)throw new ServiceException("删除菜单，菜单id不能为空");
		int count = menuDao.hasChild(menuId);
		if(count!=0)throw new ServiceException("请先删除子菜单或按钮");
		int i = menuDao.deleteObject(menuId);
		if(i!=1)throw new ServiceException("删除菜单失败！");
	}

	@Override
	public List<Node> findZtreeNodes() {
		return menuDao.findZtreeNodes();
	}

	@Override
	public int insertObject(SysMenu entity) {
		//判断参数的有效性
		if(entity==null)throw new ServiceException("添加对象不能为空");
		int rows = menuDao.insertObject(entity);
		if(rows!=1)throw new ServiceException("数据保存失败");
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null || id<1)throw new ServiceException("id的值无效");
		Map<String, Object> map =menuDao.findObjectById(id);
		return map;
	}

	@Override
	public int updateObject(SysMenu entity) {
		if(entity==null)throw new ServiceException("更新数据不能为空");
		int rows = menuDao.updateObject(entity);
		if(rows!=1)throw new ServiceException("数据更新失败");
		return rows;
	}
}
