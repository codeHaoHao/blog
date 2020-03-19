package com.lijiahao.blog.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.VisitorUrlDao;
import com.lijiahao.blog.model.VisitorUrl;
import com.lijiahao.blog.service.VisitorUrlService;
import com.lijiahao.blog.utils.TimeUtils;

@Service("VisitorUrlService")
public class VisitorUrlServiceImpl extends GenericServiceImpl<VisitorUrl> implements VisitorUrlService{
	
	@Autowired
	private VisitorUrlDao dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
	}
	
	@Override
	public int saveVisitorUrl(HttpServletRequest request, int id) {
		VisitorUrl url = new VisitorUrl();
		url.setUrl_path(request.getRequestURL().toString());
		url.setVisitor_id(id);
		url.setVisitor_time(TimeUtils.getCurrentTime());
		return add(url);
	}

}
