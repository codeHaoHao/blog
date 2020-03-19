package com.lijiahao.blog.constant;

import com.lijiahao.blog.model.GenericBean;

/**
 * 该类是Ckeditor上传图片成功后返回类的封装
 * @author Frank Li
 *
 */
public class ImageUploadModel extends GenericBean{

	private static final long serialVersionUID = -3047151586931807812L;
	
	private int uploaded;
	private String fileName;
	private String url;
	
	
	public ImageUploadModel() {
		super();
	}
	public ImageUploadModel(int uploaded, String fileName, String url) {
		super();
		this.uploaded = uploaded;
		this.fileName = fileName;
		this.url = url;
	}
	public int getUploaded() {
		return uploaded;
	}
	public void setUploaded(int uploaded) {
		this.uploaded = uploaded;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
