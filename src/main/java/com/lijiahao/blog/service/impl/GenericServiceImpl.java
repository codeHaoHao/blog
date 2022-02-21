package com.lijiahao.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.dao.Dao;
import com.lijiahao.blog.dao.cache.Cache;
import com.lijiahao.blog.model.GenericBean;

/**
 * 该类用来封装基础的方法，因此所有ServiceImpl都要继承该类
 *
 * @author Frank Li
 *
 * @param <T>
 */
public abstract class GenericServiceImpl<T extends GenericBean>
    implements InitializingBean {
  private Cache<T> cache;
  private Dao<T> dao;

  /**
   * 子类实现用于向父类注入cache和dao，此方法是InitializingBean的方法
   * @throws Exception
   */
  public abstract void afterPropertiesSet() throws Exception;

  public T get(int id) {
    T t = null;
    if (cache != null) {
      t = cache.get(id);
    }
    if (t == null) {
      t = dao.get(id);
      if (cache != null && t != null) {
        cache.set(t);
      }
    }
    return t;
  }

  public int delete(int id) {
    int r = dao.delete(id);
    if (cache != null) {
      cache.remove(id);
    }
    return r;
  }

  public int update(T t) {
    int id = t.getId();
    dao.update(t);
    if (cache != null) {
      cache.remove(id);
    }
    return id;
  }

  public int add(T t) {
    int id = dao.add(t);
    return id;
  }

  public T selectByBean(T t) {
    return dao.selectByBean(t);
  }

  @Transactional(rollbackFor = Exception.class) public PageInfo<T> getPagedList(
      int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<T> list = dao.getList();
    PageInfo<T> pageInfo = new PageInfo<T>(list);
    return pageInfo;
  }

  @Transactional(rollbackFor = Exception.class) public List<T> getList() {
    return dao.getList();
  }

  public void setCache(Cache<T> cache) {
    this.cache = cache;
  }

  public void setDao(Dao<T> dao) {
    this.dao = dao;
  }

}
