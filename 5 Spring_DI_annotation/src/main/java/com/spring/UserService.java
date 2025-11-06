package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService{
	private HelloService helloService;
	private EmailService emailService;
	
	// field injection
	@Autowired
	private SMSService smsService;
	
	public UserService() {
		System.out.println("This is default user service constructor");
	}
	
	// constructor injection
	@Autowired 
	public UserService(EmailService emailService) {
		this.emailService = emailService;
	}
	/*
	 * Note : If only one constructor is present then its not mandatory to put  @Autowired annotation on constructor but if more than one constructor is present then its mandatory to put @Autowired annotation on the constructor because it tells which constructor to use for injecting dependencies.
	 * 
	 * If default constructor is absent, then its not mandatory to to put annotation on parameterized constructor, but if default constructor is present, then its mandatory to put annotation on parameterized constructor
	 * */
	
	// setter injection
	@Autowired
	public void setHelloServices(HelloService helloService) {
		this.helloService = helloService;
	}
	/*
	 * Note : In case of setter injection in annotation based example, its mandatory to put @Autowired annotation to tell spring to inject dependency with this specific method.
	 * */
	
	public void actionPerformed() {
		System.out.println("Action performed of UserService..!!");
		helloService.printHelloService();
		smsService.printSMSService();
		emailService.printEmailMessage();
	}
}