package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.WebsiteDao;
import com.lijiahao.blog.model.Website;
import com.lijiahao.blog.service.WebsiteService;

@Service("WebsiteService")
public class WebsiteServiceImpl extends GenericServiceImpl<Website> implements WebsiteService{

	@Autowired
	private WebsiteDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}
	
	
	
}
