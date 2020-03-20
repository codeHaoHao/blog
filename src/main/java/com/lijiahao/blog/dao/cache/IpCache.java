package com.lijiahao.blog.dao.cache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lijiahao.blog.utils.TimeUtils;

/**
 * 改缓存用来解决增加文章访问量，同一个ip对同一个文章5分钟，阅读数加1
 * @author Frank li
 *
 */
@Component("IpCache")
public class IpCache{
	
	private final String PREX = "ip:";
	
	private ConcurrentHashMap<String, Long> cache = new ConcurrentHashMap<String, Long>();
	
	/**
	 * 每5分钟执行一次，清除ip缓存
	 */
	@Scheduled(fixedDelay = 300000)
	public void clearIpCache() {
		cache.forEach((k,v)->{
			long current = TimeUtils.getCurrentTime();
			if(current - v > 300000) {
				cache.remove(k);
			}
		});
	}

	public boolean canUpdateReadings(String ip, int id) {
		String key = getKey(ip, id);
		if(cache.get(key) != null) {
			return false;
		}
		set(key);
		return true;
	}
	
	private void set(String key) {
		long current = TimeUtils.getCurrentTime();
		cache.put(key, current);
	}
	
	private String getKey(String ip, int id) {
		String key = PREX + ip + "id:" + id;
		return key;
	}
}
