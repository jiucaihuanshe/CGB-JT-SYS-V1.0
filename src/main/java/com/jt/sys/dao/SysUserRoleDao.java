package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 通过这个接口操作用户与角色之间的关系数据 */
public interface SysUserRoleDao {
	//保存用户和角色直接的关系。 多对多
	int insertObject(@Param("userId") Integer userId,@Param("roleIds") String[] roleIds);
	int updateObject(@Param("userId")Integer userId,@Param("roleIds")String[] roleIds);
	List<Integer> findRolesByUserId(Integer id);
}
