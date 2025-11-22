package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class AppService{
	public void addUserService() {
		System.out.println("add_user service called");
	}

	public void viewUserService() {
		System.out.println("view_user service called");
	}

	public void errorUserService() {
		throw new RuntimeException("Throw error user service");
	}
	
}