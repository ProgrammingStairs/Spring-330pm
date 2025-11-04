package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication{
	public static void main(String args[]) {
		
	//ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
	ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");

	
//	HelloService helloObj =  (HelloService)context.getBean("helloService");
//	helloObj.getHelloServiceMessage();

	HelloService helloObj =  context.getBean(HelloService.class);
	helloObj.getHelloServiceMessage();
	
	DemoService demoObj = context.getBean(DemoService.class);
	demoObj.printDemoMessage();
	System.out.println("2 Message : "+demoObj.getDemoMessage());
	
	}
}