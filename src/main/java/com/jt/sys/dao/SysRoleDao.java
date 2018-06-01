package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.pojo.SysRole;
//数据持久层对象
public interface SysRoleDao {
	//查询所有角色信息
	List<SysRole> findPageObjects();
	//向表中写入数据
	int insertObject(SysRole entity);
	//修改角色信息
	int updateObject(SysRole entity);
	//根据id查询角色数据
	SysRole findObjectById(Integer id);
	//根据id删除角色数据
	int deleteObject(@Param("ids") String[] ids);
	
	//AJAX访问所有角色信息
	List<SysRole> findPageObject();
}
