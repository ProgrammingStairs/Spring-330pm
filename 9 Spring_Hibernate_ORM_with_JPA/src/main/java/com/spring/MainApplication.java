package com.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.dbConfig.HibernateConfig;
import com.spring.model.User;
import com.spring.service.UserService;

public class MainApplication{
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		try {
		User user = new User("Peter Parker","peter@gmail.com","peter@123");
		userService.addUser(user);
		
		User user1 = userService.getUserById(1);
		user1.setEmail("andrewdemo@gmail.com");
		userService.updateUser(user1);
		
		User user2 = userService.getUserById(1);
		System.out.println("User : "+user2);
		
		List<User> listUser = userService.getAllUsers();
		for(User obj : listUser) {
			System.out.println(obj);
		}
		
		userService.deleteUser(12);
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		
	}
}