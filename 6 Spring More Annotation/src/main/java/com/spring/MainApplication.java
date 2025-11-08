package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.service.EmailService;
import com.spring.service.HelloService;
import com.spring.service.SMSService;

@Component
public class MainApplication{
	public EmailService emailService;
	public SMSService smsService;
	
	// field injection
	@Autowired
	public HelloService helloService;
	
	// constructor injection
//	@Autowired
//	public MainApplication(@Qualifier("gmailService") EmailService emailService) {
//		this.emailService = emailService;
//	}
	@Autowired
	public MainApplication(EmailService emailService) {
		this.emailService = emailService;
	}

	
	// setter injection
	@Autowired
	public void set_sms_service(SMSService smsService) {
		this.smsService=smsService;
	}
	
	public void actionedPerformed() {
		emailService.printEmailService("How are you_email ? ");
		smsService.printSmsService("How are you_sms");
		helloService.printHelloService();
	}
	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MainApplication app = context.getBean(MainApplication.class);
		app.actionedPerformed();
		
		SMSService sms1 = context.getBean(SMSService.class);
		System.out.println("sms1 : "+sms1);
		sms1.printSmsService("Sms First");
		SMSService sms2 = context.getBean(SMSService.class);
		System.out.println("sms2 : "+sms2);
		sms2.printSmsService("Sms Second");	
		
		((AbstractApplicationContext) context).close(); // it runs @PreDestroy annoted method on @Scope("singleton")
	}
}