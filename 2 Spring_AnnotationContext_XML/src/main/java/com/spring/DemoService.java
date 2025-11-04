package com.spring;
public class DemoService{
	String demoMessage;
	
	public void setDemoMessage(String demoMessage) {
		this.demoMessage = demoMessage;
	}
	
	public String getDemoMessage() {
		return demoMessage;
	}

	public void printDemoMessage() {
		System.out.println("1 Message : "+demoMessage);
	}
	
}