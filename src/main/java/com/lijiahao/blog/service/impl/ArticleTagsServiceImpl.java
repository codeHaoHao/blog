package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.ArticleTagsDao;
import com.lijiahao.blog.model.ArticleTags;
import com.lijiahao.blog.service.ArticleTagsService;

@Service("ArticleTagsService")
public class ArticleTagsServiceImpl extends GenericServiceImpl<ArticleTags> implements ArticleTagsService{
	
	@Autowired
	private ArticleTagsDao dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
		
	}

	@Override
	public int deleteByArticleId(int id) {
		
		return dao.deleteByArticleId(id);
	}

}
