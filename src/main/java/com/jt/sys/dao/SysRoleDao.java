package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
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
	//对指定名称，进行查询，对实现方法进行重用，运用动态sql技术
	List<SysRole> findPageObject(@Param("name") String name);
	//分页查询
	/**
	 * @param name 按名字查询时的查询参数
	 * @param startIndex 分页查询时起始页的位置
	 * @param pageSize 每页最多显示多少条记录
	 * @return
	 */
	List<SysRole> findPageObject(@Param("name")String name,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	int getRowCount(@Param("name")String name);
	
	//查询角色的信息。
	List<CheckBox> findObjects();
}
