package com.lijiahao.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lijiahao.blog.model.Tags;

@Mapper
public interface TagsDao extends Dao<Tags>{
	List<Tags> getByArticleId(int id);
}
