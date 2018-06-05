package com.jt.sys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;

@Controller
@RequestMapping("/role/")
public class RoleController {
	private ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@RequestMapping("listUI")
	public String listUI(){
		System.out.println("listUI()");
		return "sys/roles2";
	}
	@RequestMapping("doTestJackson")
	@ResponseBody
	public Map<String, Object> doTestJackson(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", 100);
		map.put("name", 101);
		return map;
	}
	@Test
	public void testPool(){
		System.out.println(ctx);
		DruidDataSource dataSource= (DruidDataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		Assert.assertNotEquals(dataSource, null);
	}
	@Test
	public void testSessionFactory() {
		Object sessionFactory=ctx.getBean("sqlSessionFactory");
		System.out.println(sessionFactory);
		Assert.assertNotEquals(sessionFactory, null);
	}
	@Test
	public void testfindPageObjects(){
		//获取bean的类型
		//由Spring创建sqlSessionFactory
		SysRoleService roleService = ctx.getBean("sysRoleServiceImpl", SysRoleService.class);
		List<SysRole> list = roleService.findPageObjects();
		System.out.println(list);
	}
	@After
	public void destroy(){
		ctx.close();
	}
}
