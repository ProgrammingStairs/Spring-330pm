package com.spring.model;

public class User{
	int uid;
	String username,email;
	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	public User(int uid, String username) {
		super();
		this.uid = uid;
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}