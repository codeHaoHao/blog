package com.lijiahao.blog.service;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.Article;

public interface ArticleService extends Service<Article>{
	int addArticle(Article article, String tags);
	
	PageInfo<Article> getListOrderByReadings();
	
	PageInfo<Article> getListOrderByCreateDate(int pageNum, int pageSize);
	
	Article getPrevious(int id);
	
	Article getNext(int id);
	
	int updateArticle(Article article, String tags);
}
