package com.lijiahao.blog.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static String getAccessUrl(HttpServletRequest request, String fileName) {
		String url = "";
		String serverName = request.getServerName();
		int port = request.getServerPort();
		
		url = "http://" + serverName + ":" + port + "/showImage.html?fileName=" + fileName;
		return url;
	}
	
	public static String getAccessUrl(String fileName) {
		String url = "/showImage.html?fileName=" + fileName;
		return url;
	}
	
	/**
    *
    * @param file 文件
    * @param path 文件存放路径
    * @param fileName 源文件名
    * @return
    */
   public static String upload(MultipartFile file, String path, String fileName, ArrayList<String> errors){
	   
	   if(!checkFileSize(file.getSize(),10,"M")) {
		   errors.add("超出了最大文件大小, 最大只能上传10M");
		   return null;
	   }
	   
	   
	   String fileNewName = getFileName(fileName);
       // 生成新的文件名
       String realPath = path + "/" + fileNewName;

       //使用原文件名
//       String realPath = path + "/" + fileName;

       File dest = new File(realPath);

       //判断文件父目录是否存在
       if(!dest.getParentFile().exists()){
           dest.getParentFile().mkdir();
       }

       try {
           //保存文件
           file.transferTo(dest);
           return fileNewName;
       } catch (IllegalStateException e) {
           errors.add("超出了最大文件大小");
           return fileNewName;
       } catch (IOException e) {
    	   errors.add("上传文件出现了问题!");
           e.printStackTrace();
           return fileNewName;
       }

   }
   
   
   public static boolean checkFileSize(Long len, int size, String unit) {
//     long len = file.length();
     double fileSize = 0;
     if ("B".equals(unit.toUpperCase())) {
         fileSize = (double) len;
     } else if ("K".equals(unit.toUpperCase())) {
         fileSize = (double) len / 1024;
     } else if ("M".equals(unit.toUpperCase())) {
         fileSize = (double) len / 1048576;
     } else if ("G".equals(unit.toUpperCase())) {
         fileSize = (double) len / 1073741824;
     }
     if (fileSize > size) {
         return false;
     }
     return true;
 }
   
	/**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
    
    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }
    
    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
