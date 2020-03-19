package com.lijiahao.blog.model;

public class FrendLink extends GenericBean{

	private static final long serialVersionUID = -2587717480942087112L;
	
	private int id;
	private String name;
	private String url;
	private long create_date;
	
	
	public FrendLink() {
		super();
	}

	public FrendLink(int id, String name, String url, long create_date) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.create_date = create_date;
	}

	public long getCreate_date() {
		return create_date;
	}

	public void setCreate_date(long create_date) {
		this.create_date = create_date;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
