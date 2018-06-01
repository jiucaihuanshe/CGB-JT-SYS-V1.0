package com.jt.sys.controller;
/**
 * AJAX、访问所有信息
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jt.sys.pojo.SysRole;
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
	@RequestMapping("doFindPageObject")
	public ModelAndView doFindPageObject(){
		List<SysRole> list = sysRoleService.findPageObject();
		//ModelAndView构造方法
		ModelAndView mv = new ModelAndView();
		//返回所需要的数值，可以默认和指定返回对象的名字
		mv.addObject("data", list);
		//返回指定页面
		mv.setViewName("sys/roles");
		return mv;
	}
}
