package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService{
	@Value("${app.number}")
	String number;
	
	public SMSService() {
		System.out.println("SMSService constructor Invoked...!!!");
	}
	
	public void printSmsService(String message) {
		System.out.println("You received text sms : "+message+" from this sender : "+number);
	}
}