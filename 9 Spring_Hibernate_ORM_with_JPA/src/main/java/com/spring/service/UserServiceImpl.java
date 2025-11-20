 package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Service
@Transactional
 public class UserServiceImpl implements UserService{
	 
	@Autowired
	public UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.add(user);
	}
	
	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserById(int id) {
		return userDao.getById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers(){
		return userDao.getAllUser();
	}
	
//	@Override 
//	public void deleteUser(int id) throws Exception{
//		userDao.delete(id);
//		if(true)
//			throw new RuntimeException("Rollback occured"); // unchecked exception
//	}
	
	
	@Override 
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(int id) throws Exception{
		userDao.delete(id);
		if(true)
			throw new Exception("Rollback occured"); // checked exception
	}

 }