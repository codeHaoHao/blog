package com.lijiahao.blog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lijiahao.blog.model.Website;
import com.lijiahao.blog.service.WebsiteService;
import com.lijiahao.blog.utils.FileUtils;
import com.lijiahao.blog.utils.JsonResult;

/**
 * 网站基本信息的controller
 * @author Frank Li
 *
 */

@Controller
@RequestMapping("admin/")
public class WebsiteController extends BaseAdminController{
	
	@Value("${web.upload-path}")
    private String path;
	
	
	@Autowired
	private WebsiteService websiteService;
	
	@RequestMapping("websiteConfig.html")
	public String websiteConifg(Model model) {
		return "admin/website_config";
	}
	
	@RequestMapping(value = "saveWebsiteConfig.html", method = RequestMethod.POST)
	public String saveWebSiteConfig(Model model, Website website, @RequestParam("logo-img") MultipartFile file) {
		JsonResult result = new JsonResult();
		
		ArrayList<String> errors = new ArrayList<String>();
        String fileName = null;
        if(!file.isEmpty()) {
        	fileName = FileUtils.upload(file, path, file.getOriginalFilename(), errors);
        	website.setLogo(FileUtils.getAccessUrl(fileName));
        }
        
        if(errors.size() > 0) {
        	result.setSuccess(false);
        	result.setMessage(errors.get(0));
        	model.addAttribute("result", result);
    		return "admin/website_config";
        }
		
		int count = websiteService.update(website);
		
		if(count > 0) {
			result.setSuccess(true);
			result.setMessage("保存成功");
		} else {
			result.setSuccess(false);
			result.setMessage("保存失败");
		}
		
		model.addAttribute("result", result);
		return "admin/website_config";
	}
	
}
