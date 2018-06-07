package com.jt.sys.controller;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.PageObject;
import com.jt.sys.service.SysRoleService;

@RequestMapping("/role/")
@Controller
public class AjaxController {
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 返回一个新的页面，全局刷新
	 * 终端
	 */
	@RequestMapping("listUI0")
	public String listUI(){
		System.out.println("listUI0()");
		return "sys/role_list2";
	}
	@RequestMapping("mainUI")
	public String mainUI(){
		return "sys/main";
	}
	@RequestMapping("rightfile")
	public String rightfile(){
		return "sys/right";
	}
	@RequestMapping("addfile")
	public String addfile(){
		return "sys/role_edit";
	}
	
	/*@RequestMapping("doFindPageObject")
	public ModelAndView doFindPageObject(){
		List<SysRole> list = sysRoleService.findPageObject();
		//ModelAndView构造方法
		ModelAndView mv = new ModelAndView();
		//返回所需要的数值，可以默认和指定返回对象的名字
		mv.addObject("data", list);
		//返回指定页面
		mv.setViewName("sys/roles");
		return mv;
	}*/
}
