package com.lijiahao.blog.model;

public class Statistics extends GenericBean{
	private static final long serialVersionUID = 2705776386361803895L;
	
	public final static int TOTAL_VIEWS = 1;// 总访问量
	public final static int TOTAL_ARTICLE = 2;// 文章总数
	public final static int TOTAL_MESSAGE = 3;// 留言信息总数
	
	private int id;
	private int statistics_category;
	private String name;
	private int count;
	private long date;
	
	public Statistics() {
	}
	
	
	
	public Statistics(int id, int statistics_category, String name, int count, long date) {
		super();
		this.id = id;
		this.statistics_category = statistics_category;
		this.name = name;
		this.count = count;
		this.date = date;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatistics_category() {
		return statistics_category;
	}
	public void setStatistics_category(int statistics_category) {
		this.statistics_category = statistics_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
}
