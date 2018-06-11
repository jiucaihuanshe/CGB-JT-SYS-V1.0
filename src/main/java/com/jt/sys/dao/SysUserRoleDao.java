package com.jt.sys.dao;

import org.apache.ibatis.annotations.Param;

/** 通过这个接口操作用户与角色之间的关系数据 */
public interface SysUserRoleDao {
	//保存用户和角色直接的关系。 多对多
	int insertObject(@Param("userId") Integer userId,@Param("roleIds") String[] roleIds);
}
