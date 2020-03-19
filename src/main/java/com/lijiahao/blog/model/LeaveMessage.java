package com.lijiahao.blog.model;

public class LeaveMessage extends GenericBean{

	private static final long serialVersionUID = 3471822232684519874L;
	
	private int id;
	private int visitor_id;
	private String name;
	private String email;
	private String phone;
	private String wechat;
	private String message;
	private long create_time;
	
	
	public LeaveMessage() {
		super();
	}
	public LeaveMessage(int id, int visitor_id, String name, String email, String phone, String wechat, String message,
			long create_time) {
		super();
		this.id = id;
		this.visitor_id = visitor_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.wechat = wechat;
		this.message = message;
		this.create_time = create_time;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	
	
}
