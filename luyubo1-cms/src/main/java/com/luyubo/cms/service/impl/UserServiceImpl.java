package com.luyubo.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.CmsMd5Util;
import com.luyubo.cms.dao.UserDao;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		user.setPassword(string2md5);
		user.setCreate_time(new Date());
		user.setUpdate_time(new Date());
		user.setLocked(0);
		user.setScore(0);
		user.setRole("0");
		return userDao.insert(user)>0;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(username);
	}

	@Override
	public boolean locked(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.updateLocked(userId,1)>0;
	}

	@Override
	public boolean unLocked(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.updateLocked(userId,0)>0;
	}

	@Override
	public int addScore(Integer userId, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<User> getPageInfo(User user, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList=userDao.select(user);
		return new PageInfo<>(userList);
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		List<User> userList=userDao.login(user);
		return userList.size()>0;
	}

	@Override
	public boolean update(User user) {
		user.setUpdate_time(new Date());
		return userDao.update(user)>0;
	}

	@Override
	public boolean isExist(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(username)!=null;
	}

	@Override
	public User getById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectById(userId);
	}

}
