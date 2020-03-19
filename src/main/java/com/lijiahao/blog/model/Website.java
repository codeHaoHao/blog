package com.lijiahao.blog.model;

public class Website extends GenericBean{

	private static final long serialVersionUID = 4473673546165183311L;
	
	private int id;
	private String title;
	private String logo;
	private String keywords;
	private String description;
	private String copyright;
	
	
	public Website() {
		super();
	}
	
	public Website(int id, String title, String logo, String keywords, String description, String copyright) {
		super();
		this.id = id;
		this.title = title;
		this.logo = logo;
		this.keywords = keywords;
		this.description = description;
		this.copyright = copyright;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

}
