package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope("singleton")
//@Scope("prototype")
public class SMSService{
	@Value("${app.number}")
	String number;
	
	public SMSService() {
		System.out.println("SMSService constructor Invoked...!!!");
	}
	
	public void printSmsService(String message) {
		System.out.println("You received text sms : "+message+" from this sender : "+number);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("sms service is initialized");
	}
	/*
	Note:
	here in above annotation case, @PostConstruct method runs when bean is initialized and all dependencies injections are injected.
	*/
	
	@PreDestroy
	public void destroy() {
		System.out.println("sms service is destroyed");
	}
}