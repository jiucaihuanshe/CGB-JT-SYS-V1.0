package com.jt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.PageObject;
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
	@RequestMapping("doFindPageObject")
	@ResponseBody
	public PageObject doFindPageObject(@RequestParam("pageCurrent") Integer pageCurrent,String name){
		System.out.println("pageCurrent="+pageCurrent);
		PageObject pageObject = sysRoleService.findPageObject(pageCurrent,name);
		return pageObject;
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public List<SysRole> doFindPageObjects(){
		List<SysRole> list = sysRoleService.findPageObjects();
		return list;
	}
	@RequestMapping("doInsertObject")
	@ResponseBody
	public String doInsertObject(SysRole entity){
		sysRoleService.insertObject(entity);
		return "insert ok";
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public String doUpdateObject(SysRole entity){
		sysRoleService.updateObject(entity);
		return "update ok";
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public SysRole doFindObjectById(Integer id){
		return sysRoleService.findObjectById(id);
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public String doDeleteObject(String checkedIds){
		sysRoleService.deleteObject(checkedIds);
		return "delect ok";
	}
}
