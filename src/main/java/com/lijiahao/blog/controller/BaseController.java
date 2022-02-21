package com.lijiahao.blog.controller;

import javax.servlet.http.HttpServletRequest;

import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.UserService;
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

  @Autowired private WebsiteService websiteService;

  @Autowired private UserService userService;

  @ModelAttribute public void websiteInfo(Model model,
      HttpServletRequest request) {
    Website website = websiteService.get(1);
    if (website == null) {
      website = buildDefaultWebsite();
    }
    model.addAttribute("website", website);

    User user = userService.get(1);
    if (user == null) {
      user = buildDefaultUser();
    }
    model.addAttribute("user", user);
  }

  private User buildDefaultUser() {
    User user = new User();
    return user;
  }

  private Website buildDefaultWebsite() {
    Website website = new Website();
    website.setTitle("Blog");
    website.setTitle("My Blog");
    website.setCopyright("@Frank Li");
    website.setDescription("Franky Li Blog");
    return website;
  }

}
