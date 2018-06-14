package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.Node;
import com.jt.common.vo.SysMenu;
import com.jt.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService menuService;
	@RequestMapping("listUI")
	public String listUI(){
		return "sys/menu_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "sys/menu_edit";
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String, Object>> list = menuService.findObjects();
		return new JsonResult(1, "ok",list);
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer menuId){
		menuService.deleteObject(menuId);
		return new JsonResult();
	}
	@RequestMapping("treeUI")
	@ResponseBody
	public JsonResult treeUI(){
		List<Node> list = menuService.findZtreeNodes();
		return new JsonResult(1, "ok",list);
	}
	@RequestMapping("doInsertObject")
	@ResponseBody
	public JsonResult doInsertObject(SysMenu entity){
		menuService.insertObject(entity);
		return new JsonResult(1, "insert ok");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		Map<String, Object> map = menuService.findObjectById(id);
		return new JsonResult(1,"ok",map);
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		menuService.updateObject(entity);
		return new JsonResult(1, "update ok");
	}
}
