package com.jt.sys.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.PageObject;
import com.jt.sys.service.SysUserService;
@RequestMapping("role")
@Controller
public class SysUserController implements SysUserService{
	//与接口建立关系，@Autowired按类型注入	多个类型相同时需要注意
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("userfile")
	public String userfile(){
		return "sys/user_list";
	}
	@Override
	@RequestMapping("findUserObject")
	@ResponseBody
	public PageObject findUserObject(String username,@Param("pageCurrent")Integer pageCurrent) {
		PageObject pageObject = sysUserService.findUserObject(username, pageCurrent);
		return pageObject;
	}

}
