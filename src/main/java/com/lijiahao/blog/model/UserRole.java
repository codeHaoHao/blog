package com.lijiahao.blog.model;

public class UserRole extends GenericBean{

	private static final long serialVersionUID = -6258067915156804390L;
	
	private int id;
	private int user_id;
	private int role_id;
	
	
	
	public UserRole() {
		super();
	}
	public UserRole(int id, int user_id, int role_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.role_id = role_id;
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
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	
}
