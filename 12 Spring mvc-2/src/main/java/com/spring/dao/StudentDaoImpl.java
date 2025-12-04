package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addStudent(Student student) {
		em.persist(student);
	}
}