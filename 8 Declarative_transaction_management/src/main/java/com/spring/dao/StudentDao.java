package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;

@Repository
public class StudentDao{
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addStudent(Student student) {
		String query = "insert into studentdemo(name,email,password,address) values (?,?,?,?)";
		jdbcTemplate.update(query,student.getName(),student.getEmail(),student.getPassword(),student.getAddress());
	}
	
	public void addAuditLog(String message) {
		String query = "insert into auditlog(message) values (?)";
		jdbcTemplate.update(query,message);
	}
	
}