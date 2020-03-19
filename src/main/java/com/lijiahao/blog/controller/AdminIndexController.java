package com.lijiahao.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.Article;
import com.lijiahao.blog.model.Statistics;
import com.lijiahao.blog.service.ArticleService;
import com.lijiahao.blog.service.StatisticsService;

/**
 * admin页面首页的Controller
 * @author Frank Li
 *
 */

@Controller
@RequestMapping("admin/")
public class AdminIndexController extends BaseAdminController{
	
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("index.html")
	public String index(Model model, HttpServletRequest request) {
		Statistics total_view = statisticsService.get(Statistics.TOTAL_VIEWS);
		Statistics total_article = statisticsService.get(Statistics.TOTAL_ARTICLE);
		Statistics total_message = statisticsService.get(Statistics.TOTAL_MESSAGE);
		PageInfo<Article> article_readings_list = articleService.getListOrderByReadings();
		
		model.addAttribute("total_view", total_view.getCount());
		model.addAttribute("total_article", total_article.getCount());
		model.addAttribute("total_message", total_message.getCount());
		model.addAttribute("article_list", article_readings_list);
		return "admin/index";
	}
	
	@RequestMapping("copyright.html")
	public String leftNavigationBar() {
		return "admin/copyright";
	}
	
}
