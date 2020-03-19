package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.RoleDao;
import com.lijiahao.blog.model.Role;
import com.lijiahao.blog.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService{
	
	@Autowired
	private RoleDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}
	
	

}
