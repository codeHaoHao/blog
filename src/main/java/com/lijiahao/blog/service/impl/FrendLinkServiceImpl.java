package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.FrendLinkDao;
import com.lijiahao.blog.model.FrendLink;
import com.lijiahao.blog.service.FrendLinkService;

@Service("FrendLinkService")
public class FrendLinkServiceImpl extends GenericServiceImpl<FrendLink> implements FrendLinkService{
	
	@Autowired
	private FrendLinkDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}

}
