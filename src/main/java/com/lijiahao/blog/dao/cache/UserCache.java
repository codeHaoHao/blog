package com.lijiahao.blog.dao.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lijiahao.blog.model.User;
/**
 * user class cache, use redis
 * type : hashmap
 * key : user:id
 * 
 * redis服务器过期，改用应用服务器内存
 */
@Component("UserCache")
public class UserCache implements Cache<User>{
	
	private ConcurrentHashMap<String, User> map = new ConcurrentHashMap<String, User>();
	
	private static final String PREX = "user:";

    private static final long EXPIRE = 30; // 30 minutes
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Override
	public void expire(String key) {
    	stringRedisTemplate.expire(key, EXPIRE, TimeUnit.MINUTES);
	}

	@Override
	public User get(int id) {
		String key = PREX + id;
        User user = null;
//        if (stringRedisTemplate.hasKey(key)) {
//        	String userJson = stringRedisTemplate.opsForValue().get(key);
//        	user = JSONObject.parseObject(userJson, User.class);
//        }
        
        if(map.containsKey(key)) {
        	user = map.get(key);
        }
        return user;
	}

	@Override
	public void set(User bean) {
      String key = PREX + bean.getId();
//      String userJson = JSON.toJSONString(bean);
//      stringRedisTemplate.opsForValue().set(key, userJson);
//      expire(key);
      
      map.put(key, bean);
	}

	@Override
	public void remove(int id) {
		String key = PREX + id;
//        stringRedisTemplate.delete(key);
		map.remove(key);
	}

	@Override
	public void add(User bean) {
		String key = PREX + bean.getId();
//		String userJson = JSON.toJSONString(bean);
//		stringRedisTemplate.opsForValue().set(key, userJson);
//		expire(key);
		
		map.put(key, bean);
	}
}
