package com.lijiahao.blog.model;

public class Visitor extends GenericBean{

	private static final long serialVersionUID = 6723769795873224855L;
	
	private int id;
	private String ip;
	private long visit_time;
	
	
	public Visitor() {
		super();
	}
	public Visitor(int id, String ip, long visit_time) {
		super();
		this.id = id;
		this.ip = ip;
		this.visit_time = visit_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(long visit_time) {
		this.visit_time = visit_time;
	}
	
	

}
