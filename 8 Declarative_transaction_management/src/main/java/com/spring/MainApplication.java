package com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dbConfig.AppConfig;
import com.spring.model.Student;
import com.spring.service.StudentService;

public class MainApplication{
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		jdbcTemplate.execute("create table if not exists studentdemo(sid int primary key auto_increment,name varchar(45) not null,email varchar(45) not null,password varchar(45) not null, address varchar(45) not null)");
		jdbcTemplate.execute("create table if not exists auditlog(aid int primary key auto_increment,message varchar(45) not null)");
		
		Student stud = new Student("Peter Parker","peter@gmail.com","peter@123","Indore Madhya Pradesh");
		StudentService studService = context.getBean(StudentService.class);
		studService.performOperation(stud);
		
		context.close();
	}
}