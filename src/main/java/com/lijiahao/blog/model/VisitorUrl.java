package com.lijiahao.blog.model;

public class VisitorUrl extends GenericBean{

	private static final long serialVersionUID = -8064924294420675091L;
	
	private int id;
	private int visitor_id;
	private String url_path;
	private long visitor_time;
	
	
	
	public VisitorUrl() {
		super();
	}
	public VisitorUrl(int id, int visitor_id, String url_path, long visitor_time) {
		super();
		this.id = id;
		this.visitor_id = visitor_id;
		this.url_path = url_path;
		this.visitor_time = visitor_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVisitor_id() {
		return visitor_id;
	}
	public void setVisitor_id(int visitor_id) {
		this.visitor_id = visitor_id;
	}
	public String getUrl_path() {
		return url_path;
	}
	public void setUrl_path(String url_path) {
		this.url_path = url_path;
	}
	public long getVisitor_time() {
		return visitor_time;
	}
	public void setVisitor_time(long visitor_time) {
		this.visitor_time = visitor_time;
	}
	
	
}
