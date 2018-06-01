package com.jt.sys.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;

/**
 * 定义控制层类对象
 * @author Administrator
 *
 */
@RequestMapping("/role/")
@Controller
public class SysRoleController {
	//与接口建立关系，@Autowired按类型注入	多个类型相同时需要注意
	@Autowired
	private SysRoleService sysRoleService;
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public List<SysRole> doFindPageObjects(){
		List<SysRole> list = sysRoleService.findPageObjects();
		return list;
	}
	@RequestMapping("doInsertObject")
	@ResponseBody
	public int doInsertObject(SysRole entity){
		entity.setName("xue");
		entity.setNote("student");
		entity.setCreatedUser("tom");
		entity.setModifiedUser("tom");
		int rows = sysRoleService.insertObject(entity);
		System.out.println("rows="+rows);
		return rows;
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public int doUpdateObject(SysRole entity){
		entity.setName("dai");
		entity.setNote("teacher");
		entity.setCreatedUser("xia");
		entity.setModifiedUser("xia");
		entity.setId(3);
		int rows = sysRoleService.updateObject(entity);
		return rows;
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public SysRole doFindObjectById(SysRole entity){
		SysRole ids = sysRoleService.findObjectById(3);
		System.out.println(ids);
		return ids;
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public int doDeleteObject(){
		String[] ids = {"3","4"};
		int rows = sysRoleService.deleteObject(ids);
		return rows;
	}
}
