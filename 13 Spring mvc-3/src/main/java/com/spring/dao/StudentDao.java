package com.spring.dao;

import java.util.List;

import com.spring.entity.StudentEntity;

public interface StudentDao{
	void addStudent(StudentEntity student);
	void updateStudent(StudentEntity student);
	void deleteStudent(int sid);
	StudentEntity getStudentById(int sid);
	List<StudentEntity> getAllStudentList();
}