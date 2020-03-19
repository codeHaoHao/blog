package com.lijiahao.blog.dao.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lijiahao.blog.model.Article;
/**
 * redis服务器过期了，改用应用服务器的内存
 * @author frank
 *
 */
@Component("ArticleCache")
public class ArticleCache implements Cache<Article>{
	
	private ConcurrentHashMap<String, Article> map = new ConcurrentHashMap<String, Article>();
	
	private static final String PREX = "article:";

    private static final long EXPIRE = 24; // 24 hours
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

	@Override
	public void expire(String key) {
		stringRedisTemplate.expire(key, EXPIRE, TimeUnit.HOURS);
	}
	
	@Override
	public Article get(int id) {
		String key = PREX + id;
        Article article = null;
//        if (stringRedisTemplate.hasKey(key)) {
//        	String json = stringRedisTemplate.opsForValue().get(key);
//        	article = JSONObject.parseObject(json, Article.class);
//        }
        
        if(map.containsKey(key)) {
        	article = map.get(key);
        }
        return article;
	}

	@Override
	public void set(Article bean) {
		String key = PREX + bean.getId();
//		String json = JSON.toJSONString(bean);
//		stringRedisTemplate.opsForValue().set(key, json);
//		expire(key);
		
		map.put(key, bean);
	}

	@Override
	public void add(Article bean) {
		String key = PREX + bean.getId();
//		String json = JSON.toJSONString(bean);
//		stringRedisTemplate.opsForValue().set(key, json);
//		expire(key);
		
		map.put(key, bean);
	}

	@Override
	public void remove(int id) {
		String key = PREX + id;
//        stringRedisTemplate.delete(key);
		
		map.remove(key);
	}

}
