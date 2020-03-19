package com.lijiahao.blog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户session管理工具
 * @author Frank Li
 *
 */

public class SessionUtils {
	public final static String USER_CODE = "user_code";
	public final static String VISITOR_CODE = "visitor_code";
	
	public static Object get(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		return session.getAttribute(key);
	}
	
	public static void set(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
	public static int getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_code = (String) session.getAttribute(USER_CODE);
		if(user_code == null || user_code.isEmpty()) {
			return -1;
		}
		String user_id_s = Base64Utils.decrypt(user_code);
		if(user_id_s == null || user_id_s.isEmpty()) {
			return -1;
		}
		int user_id = -1;
		try {
			user_id = Integer.parseInt(user_id_s);
		}catch(NumberFormatException e) {
			user_id = -1;
		}
		return user_id;
	}
	
	public static void setUserId(HttpServletRequest request, int userId) {
		HttpSession session = request.getSession();
		String user_code = Base64Utils.encrypt(userId+"");
		session.setAttribute(USER_CODE, user_code);
	}
	
	public static int getVisitorId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute(VISITOR_CODE);
		if(code == null || code.isEmpty()) {
			return -1;
		}
		String id_s = Base64Utils.decrypt(code);
		if(id_s == null || id_s.isEmpty()) {
			return -1;
		}
		int id = -1;
		try {
			id = Integer.parseInt(id_s);
		}catch(NumberFormatException e) {
			id = -1;
		}
		return id;
	}
	
	public static void setVisitorId(HttpServletRequest request, int id) {
		HttpSession session = request.getSession();
		String user_code = Base64Utils.encrypt(id + "");
		session.setAttribute(VISITOR_CODE, user_code);
	}
}
