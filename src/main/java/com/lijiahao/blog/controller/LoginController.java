package com.lijiahao.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.Article;
import com.lijiahao.blog.model.Statistics;
import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.ArticleService;
import com.lijiahao.blog.service.StatisticsService;
import com.lijiahao.blog.service.UserService;
import com.lijiahao.blog.utils.JsonResult;
import com.lijiahao.blog.utils.Md5Utils;
import com.lijiahao.blog.utils.SessionUtils;
import com.wf.captcha.utils.CaptchaUtil;

/**
 * 登录controller
 * @author Administrator
 *
 */

@Controller
@RequestMapping("admin/")
public class LoginController {
	
	private final String SALT = "fdstfdgeeggd";
	
	@Autowired 
	private StatisticsService statisticsService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	@RequestMapping("captcha.html")
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CaptchaUtil.out(request, response);
	}
	
	@RequestMapping(value = "dologin.html", method = RequestMethod.POST)
	public String doLogin(Model model, String username, String password, String captcha, HttpServletRequest request) {
		JsonResult result = new JsonResult();
		
		if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
			result.setSuccess(false);
			result.setMessage("用户名和密码不能为空");
			model.addAttribute("result", result);
			return "admin/login";
		}
		
		if(captcha == null || captcha.isEmpty()) {
			result.setSuccess(false);
			result.setMessage("请输入验证码");
			model.addAttribute("result", result);
			return "admin/login";
		}
		
		if(!CaptchaUtil.ver(captcha, request)) {
			CaptchaUtil.clear(request);
			result.setSuccess(false);
			result.setMessage("验证码错误");
			model.addAttribute("result", result);
			return "admin/login";
		}
		
		User selectUser = new User();
		selectUser.setUsername(username);
		User user = userService.selectByBean(selectUser);
		if(user == null) {
			result.setSuccess(false);
			result.setMessage("用户不存在");
			model.addAttribute("result", result);
			return "admin/login";
		}
		
		if(!Md5Utils.encrypt(password, SALT).equals(user.getPassword())) {
			result.setSuccess(false);
			result.setMessage("密码错误");
			model.addAttribute("result", result);
			return "admin/login";
		}
		
		result.addDatas("user", user);
		SessionUtils.setUserId(request, user.getId());
		Statistics total_view = statisticsService.get(Statistics.TOTAL_VIEWS);
		Statistics total_article = statisticsService.get(Statistics.TOTAL_ARTICLE);
		Statistics total_message = statisticsService.get(Statistics.TOTAL_MESSAGE);
		PageInfo<Article> article_readings_list = articleService.getListOrderByReadings();
		
		model.addAttribute("total_view", total_view.getCount());
		model.addAttribute("total_article", total_article.getCount());
		model.addAttribute("total_message", total_message.getCount());
		model.addAttribute("article_list", article_readings_list);
		model.addAttribute("user", user);
		model.addAttribute("result", result);
		return "admin/index";
	}
	
}
