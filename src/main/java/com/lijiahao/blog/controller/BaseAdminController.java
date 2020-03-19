package com.lijiahao.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.UserService;
import com.lijiahao.blog.utils.SessionUtils;

/**
 * 为了能够让每个登录后的页面Model对象里存储User
 * 所有admin页面的类都要继承该类
 * @author frank Li
 *
 */
public class BaseAdminController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void userInfo(Model model, HttpServletRequest request) {
		int user_id = SessionUtils.getUserId(request);
		User user = userService.get(user_id);
		model.addAttribute("user", user);
	}

}
