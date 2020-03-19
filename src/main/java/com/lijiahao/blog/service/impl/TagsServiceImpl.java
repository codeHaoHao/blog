package com.lijiahao.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.TagsDao;
import com.lijiahao.blog.model.Tags;
import com.lijiahao.blog.service.TagsService;

@Service("TagsService")
public class TagsServiceImpl extends GenericServiceImpl<Tags> implements TagsService{
	
	@Autowired
	private TagsDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}

	@Override
	public List<Tags> getByArticleId(int id) {
		
		return dao.getByArticleId(id);
	}

}
