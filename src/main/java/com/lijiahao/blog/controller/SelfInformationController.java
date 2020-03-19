package com.lijiahao.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lijiahao.blog.constant.ImageUploadModel;
import com.lijiahao.blog.model.User;
import com.lijiahao.blog.service.UserService;
import com.lijiahao.blog.utils.FileUtils;
import com.lijiahao.blog.utils.JsonResult;
import com.lijiahao.blog.utils.SessionUtils;

/**
 * admin页面的个人信息Controller
 * @author Frank Li
 *
 */

@Controller
@RequestMapping("admin/")
public class SelfInformationController extends BaseAdminController{
	
	@Value("${web.upload-path}")
    private String path;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("selfInformation.html")
	public String selfInformation(Model model, HttpServletRequest request) {
//		int user_id = SessionUtils.getUserId(request);
//		User user = userService.get(user_id);
//		model.addAttribute("user", user);
		return "admin/self_information";
	}
	
	@RequestMapping("saveSelfInformation")
	public String saveSelfInformation(Model model, HttpServletRequest request, User user, @RequestParam("avatar-file") MultipartFile file) {
		int usreId = SessionUtils.getUserId(request);
		
		JsonResult result = new JsonResult();
		user.setId(usreId);
		
        ArrayList<String> errors = new ArrayList<String>();
        String fileName = null;
        if(!file.isEmpty()) {
        	fileName = FileUtils.upload(file, path, file.getOriginalFilename(), errors);
        	user.setAvatar(FileUtils.getAccessUrl(fileName));
        }
        if (errors.size() > 0){
        	result.setSuccess(false);
        	result.setMessage(errors.get(0));
        	return "admin/self_information";
        }
        
        userService.update(user);
        
        result.setSuccess(true);
        result.setMessage("上传成功!");
        
		
		return "admin/self_information";
	}

}
