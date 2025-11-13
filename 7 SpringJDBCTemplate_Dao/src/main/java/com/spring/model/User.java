package com.spring.model;

public class User{
	int uid;
	String name,email;
	public User() {}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public User(int uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + "]";
	}
		
}