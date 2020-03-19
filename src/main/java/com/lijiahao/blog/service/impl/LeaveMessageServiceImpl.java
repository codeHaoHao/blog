package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.LeaveMessageDao;
import com.lijiahao.blog.model.LeaveMessage;
import com.lijiahao.blog.service.LeaveMessageService;

@Service("LeaveMessageService")
public class LeaveMessageServiceImpl extends GenericServiceImpl<LeaveMessage> implements LeaveMessageService{
	
	@Autowired
	private LeaveMessageDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);
		
	}

}
