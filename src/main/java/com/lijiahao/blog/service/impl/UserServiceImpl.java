package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.UserDao;
import com.lijiahao.blog.dao.cache.UserCache;
import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.UserService;

@Service("UserService")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{
	
	@Autowired
	private UserCache cache; 
	
	@Autowired
	private UserDao dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setCache(cache);
		this.setDao(dao);
	}

}
