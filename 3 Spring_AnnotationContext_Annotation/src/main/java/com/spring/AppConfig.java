package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring")
public class AppConfig{
	
	@Bean
	public DemoService demoService() {
		return new DemoService();
	}
	
	/*
	 * Here we are creating bean (instance | object) by method
	 * here internally bean name is considered as demoService 
	 * */
}