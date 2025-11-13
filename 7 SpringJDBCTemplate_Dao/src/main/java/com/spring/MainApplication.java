package com.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;
import com.spring.dao.UserDao;
import com.spring.model.User;

public class MainApplication{
	public static void main(String args[]) {
		try {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
	
		userDao.addUser(new User("Andrew Anderson","andrew@gmail.com"));
		userDao.addUser(new User("Peter Parker","peter@gmail.com"));
		userDao.addUser(new User("Jack Jackson","jack@gmail.com"));
		userDao.addUser(new User("Mathew Math","mathew@gmail.com"));
		userDao.addUser(new User("Simon Sim","simon@gmail.com"));
		System.out.println("Data inserted successfully");
		
		userDao.updateUser(new User(2,"Andy"));
		System.out.println("Data updated successfully");
		
		userDao.deleteUser(5);
		System.out.println("Data deleted successfully");
		
		User user =  userDao.getById(6);
		System.out.println("User : "+user);
		
		List<User> list = userDao.getAllUser();
		System.out.println("Users : "+list);
		for(User userObj : list) {
			System.out.println("id : "+userObj.getUid());
			System.out.println("name : "+userObj.getName());
			System.out.println("email : "+userObj.getEmail());
		}
		
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}
}