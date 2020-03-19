package com.lijiahao.blog.model;

public class User extends GenericBean{

	private static final long serialVersionUID = 4351523410668292875L;
	
	private int id;
	private String username;
	private String password;
	private String name;
	private String profession;
	private String introduction;
	private String wechat;
	private long birthday;
	private String avatar;
	private char gender;
	private String email;
	private long recentlyLanded;
	private String aboutMe;
	
	
	
	public User(int id, String username, String password, String name, String profession, String introduction,
			String wechat, long birthday, String avatar, char gender, String email, long recentlyLanded,
			String aboutMe) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.profession = profession;
		this.introduction = introduction;
		this.wechat = wechat;
		this.birthday = birthday;
		this.avatar = avatar;
		this.gender = gender;
		this.email = email;
		this.recentlyLanded = recentlyLanded;
		this.aboutMe = aboutMe;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introducion) {
		this.introduction = introducion;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public long getBirthday() {
		return birthday;
	}
	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public long getRecentlyLanded() {
		return recentlyLanded;
	}
	public void setRecentlyLanded(long recentlyLanded) {
		this.recentlyLanded = recentlyLanded;
	}
	
	
}
