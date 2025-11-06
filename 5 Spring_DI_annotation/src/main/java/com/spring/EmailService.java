package com.spring;
public class EmailService{
	private String emailMessage;
	
	public EmailService(String email) {
		emailMessage = email;
	}
	
	public void printEmailMessage() {
		System.out.println("Email Service : "+emailMessage);
	}
}