package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Component
@Service
@Lazy
@Primary
public class GmailService implements EmailService{
	/*
	 * @Lazy will creates bean only when its needed
	 * And without @Lazy annotation, there will be eager initialization of object by default
	 * */
	
	@Value("${app.gmailEmail}")
	public String gmailEmail;
	
	public GmailService() {
		System.out.println("GmailService Constructor Invoked..!!");
	}
	@Override
	public void printEmailService(String message) {
		System.out.println("Hello Gmail User, You received this message : "+message+" from this emailid : ");
	}
}