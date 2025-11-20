package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.StudentDao;
import com.spring.model.Student;

@Service
public class StudentService{
	public StudentDao studentDao;
	
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Transactional
	public void performOperation(Student student) {
		studentDao.addStudent(student);
		studentDao.addAuditLog(student.getName()+" welcome to audit log");
		System.out.println("Operation performed");
//		if(true)
//			throw new RuntimeException("Rollback Performed");
	}
}