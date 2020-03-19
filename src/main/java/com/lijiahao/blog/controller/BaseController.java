package com.lijiahao.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lijiahao.blog.model.Website;
import com.lijiahao.blog.service.WebsiteService;


/**
 * 所有的controller都继承该controller
 * 该controller用来向页面添加网站基础信息
 * @author Frank Li
 *
 */
public class BaseController {
	
	@Autowired
	private WebsiteService websiteService;
	
	@ModelAttribute
	public void websiteInfo(Model model, HttpServletRequest request) {
		Website website = websiteService.get(1);
		model.addAttribute("website", website);
	}
	
}
