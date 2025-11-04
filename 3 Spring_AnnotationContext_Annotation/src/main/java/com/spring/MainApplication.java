package com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication{
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		HelloService obj = context.getBean(HelloService.class);
		obj.displayMessage();
		
		DemoService objDemo = context.getBean(DemoService.class);
		objDemo.printService();
		
	}
}