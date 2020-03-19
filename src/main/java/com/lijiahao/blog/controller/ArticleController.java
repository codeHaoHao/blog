package com.lijiahao.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.Article;
import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.ArticleService;
import com.lijiahao.blog.service.UserService;
import com.lijiahao.blog.utils.JsonResult;
import com.lijiahao.blog.utils.TimeUtils;

/**
 * admin页面的文章管理controller
 * @author Frank Li
 *
 */

@Controller
@RequestMapping("admin/")
public class ArticleController extends BaseAdminController{
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "article_list.html", method = RequestMethod.GET)
	public String articleList(Model model, @RequestParam(value="pageNum",defaultValue="1")int pageNum) {
		int pageSize = 10; // 每页显示数据数
		PageInfo<Article> page = articleService.getPagedList(pageNum, pageSize);
		model.addAttribute("page", page);
		
		return "admin/article_list";
	}
	
	@RequestMapping(value = "create_article_page.html", method = RequestMethod.GET)
	public String createArticlePage() {
		return "admin/create_article_page";
	}
	
	@RequestMapping(value = "create_article.html", method = RequestMethod.POST)
	public String createArticle(Model model, Article article, String tags) {
		long currentTime = TimeUtils.getCurrentTime();
		article.setCreate_date(currentTime);
		article.setUpdate_date(currentTime);
		article.setAuthor("程序员小浩");
		int article_id = articleService.addArticle(article, tags);
		
		return "admin/create_article_page";
	}
	
	@RequestMapping(value = "deleteArticle")
	@ResponseBody
	public JsonResult deleteArticle(Model model, String article_id) {
		
		int articleId = Integer.parseInt(article_id);
		JsonResult result = new JsonResult();

		Article article = articleService.get(articleId);
		if(article == null) {
			result.setSuccess(false);
			result.setMessage("wrong article_id");
			return result;
		}
		
		articleService.delete(articleId);
		result.setSuccess(true);
		result.setMessage("删除成功");
		
		
		return result;
	}
	
	@RequestMapping(value = "editArticlePage.html", method = RequestMethod.GET)
	public String editArticlePage(Model model, int id) {
		Article article = articleService.get(id);
		model.addAttribute("article", article);
		return "admin/edit_article_page";
	}
	
	@RequestMapping(value = "editArticle", method = RequestMethod.POST)
	public String editArticle(Model model, Article article, String tags) {
		JsonResult result = new JsonResult();
		articleService.updateArticle(article, tags);
		Article new_article = articleService.get(article.getId());
		model.addAttribute("article", new_article);
		result.setSuccess(true);
		result.setMessage("修改成功");
		model.addAttribute("result", result);
		
		return "admin/edit_article_page";
	}
	
}
