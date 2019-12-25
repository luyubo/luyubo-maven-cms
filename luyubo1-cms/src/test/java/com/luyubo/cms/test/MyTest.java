package com.luyubo.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luyubo.cms.common.CmsMd5Util;
import com.luyubo.cms.dao.UserDao;
import com.luyubo.cms.pojo.Complain;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.TousuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-beans.xml")
public class MyTest {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TousuService tousuService;
	@Test
	public void select() {
		List<User> userList = userDao.select(null);
		System.out.println(userList);
	}
	
	@Test
	public void md5Test() {
		String string2md5 = CmsMd5Util.string2MD5("admin");
		System.out.println(string2md5);
		
	}
	
	@Test
	public void tousuTest() {
		Complain complain =new Complain(null,44,190,"D","http://","2019-12-25 10:41:35");
		boolean add = tousuService.add(complain);
		System.out.println(add);
	}
}
