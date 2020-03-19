package com.lijiahao.blog.service;

import javax.servlet.http.HttpServletRequest;

import com.lijiahao.blog.model.Visitor;

public interface VisitorService extends Service<Visitor>{
	/**
	 * 保存visitor
	 * @param request
	 * @return
	 */
	int saveVisitor(HttpServletRequest request);
}
