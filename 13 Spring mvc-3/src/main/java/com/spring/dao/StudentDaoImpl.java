package com.spring.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.spring.entity.StudentEntity;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Override
	public void addStudent(StudentEntity student) {
		
	}
	@Override
	public void updateStudent(StudentEntity student) {
		
	}
	@Override
	public void deleteStudent(int sid) {
		
	}
	@Override
	public StudentEntity getStudentById(int sid) {
		return null;
	}
	@Override
	public List<StudentEntity> getAllStudentList(){
		return null;
	}
}