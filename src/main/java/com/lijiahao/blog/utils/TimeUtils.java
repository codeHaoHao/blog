package com.lijiahao.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间管理工具类
 * @author Frank Li
 *
 */
public class TimeUtils {
	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static String getdate(long milliseconds, String pattern) {
		
		Date date = new Date(milliseconds);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}
	
	public static long getdate(String date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date_o = null;
		try {
			date_o = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date_o.getTime();
	}
	
	public static String getCurrentTime(String pattern) {
		Long milliseconds = System.currentTimeMillis();
		return getdate(milliseconds, pattern);
	}
	
	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}
	
	public static long getTodayDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		long milliseconds = -1L;
		try {
			Date date = formatter.parse(dateString);
			milliseconds = date.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return milliseconds;
	}
}
