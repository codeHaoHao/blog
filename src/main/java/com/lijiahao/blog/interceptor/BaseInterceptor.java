package com.lijiahao.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lijiahao.blog.utils.SessionUtils;

/**
 * 该类做了后台页面拦截，判断是否登录，登录后才能进入后台
 * @author frank
 *
 */
@Component
public class BaseInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		int user_id = SessionUtils.getUserId(request);
		if(user_id == -1) {
			response.sendRedirect(request.getContextPath() + "/admin/login.html");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
