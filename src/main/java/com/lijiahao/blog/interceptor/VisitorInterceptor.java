package com.lijiahao.blog.interceptor;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lijiahao.blog.model.Visitor;
import com.lijiahao.blog.model.VisitorUrl;
import com.lijiahao.blog.service.VisitorService;
import com.lijiahao.blog.service.VisitorUrlService;
import com.lijiahao.blog.utils.SessionUtils;
import com.lijiahao.blog.utils.TimeUtils;

/**
 * 记录visitor的信息
 * @author Frank Li
 *
 */

public class VisitorInterceptor implements HandlerInterceptor{
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private VisitorUrlService visitorUrlService;
	
	private ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int visitor_id = SessionUtils.getVisitorId(request);
		if(visitor_id == -1) {
			// 保存visitor
			
			String ip = request.getRemoteAddr();
			
			int id = visitorService.saveVisitor(request);
			SessionUtils.setVisitorId(request, id);
			
			// 保存visitor访问url
			visitorUrlService.saveVisitorUrl(request, id);
		} else {
			// 保存visitor访问url
			visitorUrlService.saveVisitorUrl(request, visitor_id);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
