package com.lijiahao.blog.service;

import java.util.List;

import com.lijiahao.blog.model.Tags;

public interface TagsService extends Service<Tags>{
	List<Tags> getByArticleId(int id);
}
