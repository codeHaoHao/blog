package com.lijiahao.blog.model;

import java.util.List;

public class Article extends GenericBean{

	private static final long serialVersionUID = -8358137367283432718L;
	
	private int id;
	private int user_id;
	private String author;
	private String title;
	private String image_url;
	private String content;
	private long create_date;
	private long update_date;
	private int likes;
	private int readings;
	private int sort;
	private int status; // 0 禁用  1 正常
	private String summary;
	
	private List<Tags> tagsList;
	private String tagsStr;
	
	public Article() {
		super();
	}
	
	

	public Article(int id, int user_id, String author, String title, String image_url, String content, long create_date,
			long update_date, int likes, int readings, int sort, int status, String summary) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.author = author;
		this.title = title;
		this.image_url = image_url;
		this.content = content;
		this.create_date = create_date;
		this.update_date = update_date;
		this.likes = likes;
		this.readings = readings;
		this.sort = sort;
		this.status = status;
		this.summary = summary;
	}



	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCreate_date() {
		return create_date;
	}
	public void setCreate_date(long create_date) {
		this.create_date = create_date;
	}
	public long getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(long update_date) {
		this.update_date = update_date;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getReadings() {
		return readings;
	}
	public void setReadings(int readings) {
		this.readings = readings;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Tags> getTagsList() {
		return tagsList;
	}

	public void setTagsList(List<Tags> tagsList) {
		this.tagsList = tagsList;
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<tagsList.size();i++) {
			Tags tag = tagsList.get(i);
			if(i == tagsList.size()) {
				buffer.append(tag.getName());
			}
			
			buffer.append(tag.getName() + ",");
		}
		setTagsStr(buffer.toString());
	}

	public String getTagsStr() {
		return tagsStr;
	}
	public void setTagsStr(String tagsStr) {
		this.tagsStr = tagsStr;
	}
	
}
