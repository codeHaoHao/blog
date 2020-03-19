package com.lijiahao.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lijiahao.blog.model.Article;

@Mapper
public interface ArticleDao extends Dao<Article>{
	List<Article> getListArticles();
	
	int getPrevious(int id);
	
	int getNext(int id);
}
