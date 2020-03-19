package com.lijiahao.blog.service;

import javax.servlet.http.HttpServletRequest;

import com.lijiahao.blog.model.VisitorUrl;

public interface VisitorUrlService extends Service<VisitorUrl>{
	/**
	 * 保存visitor访问url
	 * @param request
	 * @param id
	 * @return
	 */
	int saveVisitorUrl(HttpServletRequest request, int id);
}
