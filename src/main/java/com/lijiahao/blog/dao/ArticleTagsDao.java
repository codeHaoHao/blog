package com.lijiahao.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lijiahao.blog.model.ArticleTags;

@Mapper
public interface ArticleTagsDao extends Dao<ArticleTags>{
	int deleteByArticleId(int id);
}
