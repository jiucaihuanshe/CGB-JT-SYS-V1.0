package com.jt.sys.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysUserService;
@RequestMapping("user")
@Controller
public class SysUserController{
	//与接口建立关系，@Autowired按类型注入	多个类型相同时需要注意
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("userfile")
	public String userfile(){
		return "sys/user_list";
	}
	@RequestMapping("userEdit")
	public String userEdit(){
		return "sys/user_edit";
	}
	@RequestMapping("pageUI")
	public String pageUI(){
		return "sys/page";
	}
	@RequestMapping("dofindUserObject")
	@ResponseBody
	public JsonResult dofindUserObject(String username,@Param("pageCurrent")Integer pageCurrent) {
		PageObject<SysUser> pageObject = sysUserService.findUserObject(username, pageCurrent);
		return new JsonResult(1,"query ok",pageObject);
	}
	@RequestMapping("dovalidById")
	@ResponseBody
	public JsonResult dovalidById(Integer id,Integer valid){
		sysUserService.validById(id, valid,"admin");
		return new JsonResult(1,"valid ok");
	}
	
	
	
	
	
	
	
	
	/*@RequestMapping("dosaveObject")
	@ResponseBody
	public JsonResult dosaveObject(SysUser entity){
		sysUserService.saveObject(entity);
		return new JsonResult(1,"save ok");
	}
	
	public JsonResult dofindUserById(Integer id){
		SysUser sysUser = sysUserService.findUserById(id);
		return new JsonResult(1,"query id ok",sysUser);
	}*/

}
