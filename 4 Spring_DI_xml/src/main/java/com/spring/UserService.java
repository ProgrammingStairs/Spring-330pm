package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService{
	private HelloService helloService;
	private EmailService emailService;
	
	// Field Injection
	@Autowired
	private SMSService smsService;
	
	
	// Constructor injection
	public UserService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	// setter injection
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	public void actionPerformed() {
		System.out.println("ActionPerformed ...");
		System.out.println(helloService.getHelloMessage());
		emailService.printEmailMessage();
		smsService.printSMSService();
	}
}