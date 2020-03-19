package com.lijiahao.blog.service;

import com.lijiahao.blog.model.Statistics;

public interface StatisticsService extends Service<Statistics>{
	int getTodayTotalViews();
}
