package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService{
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id) throws Exception;
	public User getUserById(int id);
	public List<User> getAllUsers();
}