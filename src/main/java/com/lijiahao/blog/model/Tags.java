package com.lijiahao.blog.model;

public class Tags extends GenericBean{

	private static final long serialVersionUID = 7751457860211677462L;
	
	private int id;
	private String name;
	private double weight;
	
	
	
	public Tags() {
		super();
	}
	public Tags(int id, String name, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
}
