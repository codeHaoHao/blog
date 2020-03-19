package com.lijiahao.blog.model;

public class ArticleTags extends GenericBean{

	private static final long serialVersionUID = -5517277894203701857L;
	
	private int id;
	private int article_id;
	private int tags_id;
	
	
	public ArticleTags(int article_id, int tags_id) {
		super();
		this.article_id = article_id;
		this.tags_id = tags_id;
	}
	public ArticleTags() {
		super();
	}
	public ArticleTags(int id, int article_id, int tags_id) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.tags_id = tags_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getTags_id() {
		return tags_id;
	}
	public void setTags_id(int tags_id) {
		this.tags_id = tags_id;
	}
	
	

}
