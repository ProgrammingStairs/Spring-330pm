package com.spring.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.entity.StudentEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
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