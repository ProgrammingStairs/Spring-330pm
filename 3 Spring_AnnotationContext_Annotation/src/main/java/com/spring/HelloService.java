package com.spring;

import org.springframework.stereotype.Component;

/*
 here we are creating bean(instance | object) by class
 by putting @Component annotation
*/
@Component
public class HelloService{
	public void displayMessage() {
		System.out.println("This is an example of Annotation");
	}
}


/*
	@Component
	public class HelloService{}
	
	Internally @Component annotation makes bean of HelloService class by helloService name
*/
