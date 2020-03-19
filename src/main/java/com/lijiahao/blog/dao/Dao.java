package com.lijiahao.blog.dao;

import java.util.List;

import com.lijiahao.blog.model.GenericBean;

/**
 * Dao类的顶层接口，所有Dao类都要继承该接口
 * @author Frank Li
 *
 * @param <T>
 */
public interface Dao<T extends GenericBean> {
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
    
    List<T> getList();
}
