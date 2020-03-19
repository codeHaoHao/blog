package com.lijiahao.blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.GenericBean;
/**
 * service类的顶层接口，所有service接口都要继承该接口
 * @author Frank Li
 *
 * @param <T>
 */
public interface Service<T extends GenericBean> {
	T get(int id);
    
    int delete(int id);
    
    /**
     * return object id
     * @return id
     */
    int update(T t);
    
    /**
     * return object id
     * @return id
     */
    int add(T t);
    
    T selectByBean(T t);
    
    PageInfo<T> getPagedList(int pageNum, int pageSize);
    
    List<T> getList();
}
