package com.lijiahao.blog.dao.cache;

import com.lijiahao.blog.model.GenericBean;

/**
 * 缓存顶层接口，所有实现缓存的类实现此接口
 * @author Frank Li
 *
 * @param <T>
 */

public interface Cache<T> {
    void expire(String key);
	T get(int id);
    void set(T bean);
    void add(T bean);
    void remove(int id);
}
