package com.lijiahao.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lijiahao.blog.model.User;

@Mapper
public interface UserDao extends Dao<User> {

}
