package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.UserRoleDao;
import com.lijiahao.blog.model.UserRole;
import com.lijiahao.blog.service.UserRoleService;

@Service("UserRoleService")
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole> implements UserRoleService{
	
	@Autowired
	private UserRoleDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}

}
