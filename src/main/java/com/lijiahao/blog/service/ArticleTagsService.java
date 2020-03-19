package com.lijiahao.blog.service;

import com.lijiahao.blog.model.ArticleTags;

public interface ArticleTagsService extends Service<ArticleTags>{
	int deleteByArticleId(int id);
}
