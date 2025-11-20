package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDao{
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User getById(int id);
	public List<User> getAllUser();
}