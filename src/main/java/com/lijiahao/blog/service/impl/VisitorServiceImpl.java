package com.lijiahao.blog.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.VisitorDao;
import com.lijiahao.blog.model.Visitor;
import com.lijiahao.blog.service.VisitorService;
import com.lijiahao.blog.utils.TimeUtils;

@Service("VisitorService")
public class VisitorServiceImpl extends GenericServiceImpl<Visitor> implements VisitorService{
	
	@Autowired
	private VisitorDao dao; 
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null); 
		
	}

	@Override
	public int  saveVisitor(HttpServletRequest request) {
		Visitor visitor = new Visitor();
		String ip = request.getRemoteAddr();
		visitor.setIp(ip);
		visitor.setVisit_time(TimeUtils.getCurrentTime());
		return add(visitor);
	}

}
