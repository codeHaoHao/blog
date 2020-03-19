package com.lijiahao.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lijiahao.blog.constant.ImageUploadModel;
import com.lijiahao.blog.utils.FileUtils;
import com.lijiahao.blog.utils.JsonResult;

/**
 * 上传图片Controller
 * @author Frank Li
 *
 */

@Controller
public class UploadImageController {
	@Value("${web.upload-path}")
    private String path;
	
	private final ResourceLoader resourceLoader;
	
	@Autowired
	public UploadImageController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@RequestMapping(value = "imageUpload", method = RequestMethod.POST)
	@ResponseBody
	public ImageUploadModel imageUpload(@RequestParam("upload") MultipartFile file, HttpServletRequest request) {
		JsonResult result = new JsonResult();
		ImageUploadModel model = new ImageUploadModel();
		
        ArrayList<String> errors = new ArrayList<String>();
        String fileName = FileUtils.upload(file, path, file.getOriginalFilename(), errors);
        if (errors.size() > 0){
        	result.setSuccess(false);
        	result.setMessage(errors.get(0));
        	return model;
        }

        
        result.setSuccess(true);
        result.setMessage("上传成功!");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileName", fileName);
        result.setMap(map);
        
        model.setFileName(fileName);
        model.setUrl("http://"+request.getServerName() + ":" +request.getServerPort() +"/showImage.html?fileName="+fileName);
        model.setUploaded(1);
		return model;
	}
	
	/**
     * 显示单张图片
     * @return
     */
    @RequestMapping("showImage.html")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
