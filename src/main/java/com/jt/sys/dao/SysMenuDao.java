package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.common.vo.SysMenu;

public interface SysMenuDao {
	List<Map<String,Object>> findObjects();
	
	//删除菜单需要先查询是否有子菜单，判断子菜单的总数为0，才能删除。
	/**
	 * 从业务角色砸对菜单进行删除操作时，只能删除树结构中的叶子节点(没有子的菜单的节点)
	 * 从技术角度实现上，在执行删除操作应先查询这个菜单下有没有菜单，可以通过对子元素个数
	 * 进行统计实现。假如统计结构为0表示没有子元素，这个就可以对菜单进行删除操作了。
	 */
	int hasChild(Integer menuId);
	int deleteObject(Integer id);
	
	//定义查询节点的方法
	List<Node> findZtreeNodes();
	int insertObject(SysMenu entity);
	
	Map<String, Object> findObjectById(Integer id);
	int updateObject(SysMenu entity);
}
