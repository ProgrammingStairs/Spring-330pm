package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;

//@Component
@Service
public class YahooService implements EmailService{
	
	@Value("${app.yahooEmail}")
	public String yahooEmail;
	
	public YahooService() {
		System.out.println("YahooService Constructor Invoked..!!");
	}
	@Override
	public void printEmailService(String message) {
		System.out.println("Hello Yahoo User, You received this message : "+message+" from this emailid : "+yahooEmail);
	}
}