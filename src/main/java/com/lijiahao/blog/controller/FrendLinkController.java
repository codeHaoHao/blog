package com.lijiahao.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.model.FrendLink;
import com.lijiahao.blog.service.FrendLinkService;
import com.lijiahao.blog.utils.JsonResult;
import com.lijiahao.blog.utils.TimeUtils;

/**
 * admin页面友情连接Controller
 * @author Frank Li
 *
 */

@Controller
@RequestMapping("admin/")
public class FrendLinkController extends BaseAdminController{
	
	@Autowired
	private FrendLinkService frendLinkService;
	
	@RequestMapping("frendLinkPage.html")
	public String frendLinkPage(Model model, @RequestParam(value="pageNum",defaultValue="1")int pageNum) {
		int pageSize = 10;
		PageInfo<FrendLink> page = frendLinkService.getPagedList(pageNum, pageSize);
		
		model.addAttribute("page", page);
		
		return "admin/frend_link_list";
	}
	
	@RequestMapping(value = "createFrendLink", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult createFrendLink(FrendLink frendLink) {
		JsonResult result = new JsonResult();
		
		frendLink.setCreate_date(TimeUtils.getCurrentTime());
		int id = frendLinkService.add(frendLink);
		if(id >-1) {
			result.setSuccess(true);
			result.setMessage("创建成功");
		} else {
			result.setSuccess(false);
			result.setMessage("创建失败");
		}
		
		return result;
	}
	
	@RequestMapping( value = "deleteFrendLink", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteFrendLink(int id) {
		JsonResult result = new JsonResult();
		
		int count = frendLinkService.delete(id);
		if(count > 0) {
			result.setSuccess(true);
			result.setMessage("删除成功");
		} else {
			result.setSuccess(false);
			result.setMessage("删除失败");
		}
		
		return result;
	}
	
	@RequestMapping(value = "editFrendLink", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult editFrendLink(FrendLink frendLink) {
		JsonResult result = new JsonResult();
		
		int count = frendLinkService.update(frendLink);
		if(count > 0) {
			result.setSuccess(true);
			result.setMessage("修改成功");
		} else {
			result.setSuccess(false);
			result.setMessage("修改失败");
		}
		
		return result;
	}
}
