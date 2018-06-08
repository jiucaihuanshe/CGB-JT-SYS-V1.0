package com.jt.sys.service.impl;
/**
 * 创建角色Service实现类
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public int insertObject(SysRole entity) {
		if("admin".equals(entity.getName()))
		throw new ServiceException("此角色已经存在");
		int insert = sysRoleDao.insertObject(entity);
		return insert;
	}
	@Override
	public int updateObject(SysRole entity) {
		if(entity==null){
			throw new ServiceException("更新对象不能为空");
		}
		if(entity.getId()==null){
			throw new ServiceException("更新对象的id不能为空");
		}
		return sysRoleDao.updateObject(entity);
	}
	@Override
	public SysRole findObjectById(Integer id) {
		if(id==null){
			throw new ServiceException("id is null");
		}
		SysRole entity=sysRoleDao.findObjectById(id);
		return entity;
	}
	@Override
	public int deleteObject(String ids) {
		//业务层进行数组，传输过来的id为一个String，需要进行切割，转换成数组，进行传递。
		//业务判断，判断ids是否有值或长度是否为0
		if(ids==null | ids.length()==0){
			throw new ServiceException("选中的记录不能为空");
		}
		String[] checkedIds = ids.split(",");
		return sysRoleDao.deleteObject(checkedIds);
	}
	@Override
	public PageObject findPageObject(Integer pageCurrent, String name) {
		if(pageCurrent<1){
			throw new ServiceException("当前页码不能为负数");
		}
		//1.获取当前页数据
		int pageSize=3;//每页3条数据，>0	>3	>6
		int startIndex=(pageCurrent-1)*pageSize;
		//startIndex 查询的起始位置
		List<SysRole> list = sysRoleDao.findPageObject(name, startIndex, pageSize);
		//2.获取总记录数,计算总页数
		int rowCount=sysRoleDao.getRowCount(name);
		int pageCount=rowCount/pageSize;
		//为了求余是否为0，不等于0，总页数要往后+1
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//3.封装数据(封装到PageObject)
		PageObject pageObject = new PageObject();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}
	
	//-----------------------------------------------------------------
	@Override
	public List<SysRole> findPageObjects() {
		List<SysRole> list = sysRoleDao.findPageObjects();
		return list;
	}
	@Override
	public List<SysRole> findPageObject(String name) {
		List<SysRole> list = sysRoleDao.findPageObject(name);
		return list;
	}
}
