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
		if(entity==null){
			throw new RuntimeException("更新对象不能为空");
		}
		if(entity.getId()==null){
			throw new RuntimeException("更新对象的id不能为空");
		}
		return sysRoleDao.updateObject(entity);
	}
	@Override
	public SysRole findObjectById(Integer id) {
		if(id==null){
			throw new RuntimeException("id is null");
		}
		SysRole entity=sysRoleDao.findObjectById(id);
		return entity;
	}
	@Override
	public int deleteObject(String ids) {
		//业务层进行数组，传输过来的id为一个String，需要进行切割，转换成数组，进行传递。
		//业务判断，判断ids是否有值或长度是否为0
		if(ids==null | ids.length()==0){
			throw new RuntimeException("选中的记录不能为空");
		}
		String[] checkedIds = ids.split(",");
		return sysRoleDao.deleteObject(checkedIds);
	}
	@Override
	public List<SysRole> findPageObject(String name) {
		List<SysRole> list = sysRoleDao.findPageObject(name);
		return list;
	}

}
