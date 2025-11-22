package com.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.config.AppConfig;
import com.spring.service.AppService;

public class MainApplication{
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppService appService = context.getBean(AppService.class);
		
		appService.addUserService();
		appService.viewUserService();
		try {
			appService.errorUserService();
		}catch(Exception e) {
			System.out.println("Exception occured : "+e);
		}
	}
}