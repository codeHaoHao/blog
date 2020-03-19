package com.lijiahao.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error/")
public class ErrorPageController extends BaseController{
	
	@RequestMapping("404.html")
	public String error404() {
		return "error/404";
	}
}
