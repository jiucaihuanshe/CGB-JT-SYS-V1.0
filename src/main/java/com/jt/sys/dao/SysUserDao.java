package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.pojo.SysUser;

public interface SysUserDao {
	//查询 name,All,考虑分页的话，有startIndex,pageSize
	List<SysUser> findUserObject(@Param("username")String username,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	int getRowCount(@Param("username")String username);
	//通过这个方法实现禁用启用操作。 实现功能有3个注意，需要id，valid，修改人
	int validById(@Param("id")Integer id,@Param("valid")Integer valid,@Param("modifiedUser")String modifiedUser);
	
	//增加
	int insertObject(SysUser entity);
	//修改
	int updateObject(SysUser entity);
	
	//根据id查找用户信息
	SysUser findObjectById(Integer id);
	
	//删除
	int deleteObject(Integer id);
}
