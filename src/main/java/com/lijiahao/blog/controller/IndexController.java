package com.lijiahao.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.Article;
import com.lijiahao.blog.model.Tags;
import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.ArticleService;
import com.lijiahao.blog.service.TagsService;
import com.lijiahao.blog.service.UserService;

/**
 * 向用户展示的页面Controller
 * @author Frank Li
 *
 */

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TagsService tagsService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/index.html")
	public String index(Model model, HttpServletRequest request, @RequestParam(value="pageNum",defaultValue="1")int pageNum) {
		List<Tags> tags = tagsService.getList();
		User user = userService.get(0);
		PageInfo<Article> page = articleService.getListOrderByCreateDate(pageNum, 10);
		PageInfo<Article> readingRank = articleService.getListOrderByReadings();
		
		model.addAttribute("user", user);
		model.addAttribute("tags", tags);
		model.addAttribute("page", page);
		model.addAttribute("readingRank", readingRank);
		return "index";
	}
	
	@RequestMapping("/header.html")
	public String header() {
		return "header";
	}
	
	@RequestMapping("/list.html")
	public String list() {
		return "list";
	}
	
	@RequestMapping("/about.html")
	public String about(Model model, HttpServletRequest request) {
		User user = userService.get(0);
		model.addAttribute("user", user);
		return "about";
	}
	
	@RequestMapping("/share.html")
	public String share() {
		return "share";
	}
	
	@RequestMapping("/info.html")
	public String info(Model model, int id) {
		Article article = articleService.get(id);
		Article previous = articleService.getPrevious(id);
		Article next = articleService.getNext(id);
		User user = userService.get(0);
		List<Tags> tags = tagsService.getList();
		PageInfo<Article> readingRank = articleService.getListOrderByReadings();
		
		model.addAttribute("readingRank", readingRank);
		model.addAttribute("tags", tags);
		model.addAttribute("user", user);
		model.addAttribute("article", article);
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		return "info";
	}
	
	@RequestMapping("/gbook.html")
	public String gbook(Model model, HttpServletRequest request) {
		User user = userService.get(0);
		model.addAttribute("user", user);
		
		return "gbook";
	}
}
