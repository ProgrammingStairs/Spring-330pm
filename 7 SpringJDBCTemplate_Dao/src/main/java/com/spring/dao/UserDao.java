package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDao{
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	User getById(int userId);
	List<User> getAllUser();
}