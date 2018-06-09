package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.pojo.SysUser;
import com.jt.sys.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired//默认按类型注入
	@Qualifier("sysUserDao")//假如在当前运行的环境中，这个类型的对象有多个，执行默认类型注入时可能会失败，按名字注入
	private SysUserDao sysUserDao;
	@Override
	public PageObject<SysUser> findUserObject(String username, Integer pageCurrent) {
		if(pageCurrent<1){
			throw new ServiceException("当前页码不能为负数");
		}
		//1.获取当前页数据
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUser> list = sysUserDao.findUserObject(username, startIndex, pageSize);
		//2.获取总记录数，计算总页数
		int rowCount = sysUserDao.getRowCount(username);
		int pageCount = rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//3.封装数据
		PageObject<SysUser> pageObject = new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}
	
	@Override
	public int validById(Integer id,Integer valid,String modifiedUser) {
		//1.参数有效性验证
		if(id==null || id<0)throw new ServiceException("id不能为空");
		if(valid==null || valid<0)throw new ServiceException("状态值不能为空");
		//2.修改状态信息
		int rows = sysUserDao.validById(id, valid,modifiedUser);
		return rows;
	}
	
	
	
	
	
	
	
	/*@Override
	public int saveObject(SysUser entity) {
		if("admin".equals(entity.getUsername()))
		throw new ServiceException("此角色已经存在");
		int rows = sysUserDao.saveObject(entity);
		return rows;
	}
	
	@Override
	public SysUser findUserById(Integer id) {
		if(id==null)
		throw new ServiceException("查询的id不能为空");
		SysUser entity = sysUserDao.findUserById(id);
		return entity;
	}
	@Override
	public int updateObject(SysUser entity) {
		if(entity==null){
			throw new ServiceException("更新的对象不能为空");
		}
		if(entity.getId()==null){
			throw new ServiceException("更新的对象的id不能为空");
		}
		int rows = sysUserDao.updateObject(entity);
		return rows;
	}
	@Override
	public int deleteObject(Integer id) {
		if(id==null){
			throw new ServiceException("选中的记录不能为空");
		}
		int rows = sysUserDao.deleteObject(id);
		return rows;
	}*/
	
}
