package com.lijiahao.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijiahao.blog.dao.StatisticsDao;
import com.lijiahao.blog.model.Statistics;
import com.lijiahao.blog.service.StatisticsService;
import com.lijiahao.blog.utils.TimeUtils;

@Service("StatisticsService")
public class StatisticsServiceImpl extends GenericServiceImpl<Statistics> implements StatisticsService{
	
	@Autowired
	private StatisticsDao dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(null);// no cache
	}

	@Override
	public int getTodayTotalViews() {
		Statistics select = new Statistics();
		select.setStatistics_category(Statistics.TOTAL_VIEWS);
		select.setDate(TimeUtils.getTodayDate());
		Statistics statistics =  dao.selectByBean(select);
		return statistics.getCount();
	}

}
