package com.lijiahao.blog.model;

public class Role extends GenericBean{

	private static final long serialVersionUID = -1187313891915111320L;
	
	private int id;
	private String name;
	
	
	
	public Role() {
		super();
	}
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
