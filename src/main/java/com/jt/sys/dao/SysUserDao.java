package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.pojo.SysUser;

public interface SysUserDao {
	//查询 name,All,考虑分页的话，有startIndex,pageSize
	List<SysUser> findUserObject(@Param("username")String username,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	int getRowCount(@Param("username")String username);
	//id查询
	SysUser findUserById(Integer id);
	//增加
	int saveObject(SysUser entity);
	//修改
	int updateObject(SysUser entity);
	//删除
	int deleteObject(Integer id);
}
