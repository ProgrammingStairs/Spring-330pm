package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void add(User user) {
		em.persist(user);
		System.out.println("Data inserted successfully");
	}
	
	@Override
	public void update(User user) {
		em.merge(user);
		System.out.println("Data updated successfully");
	}
	
	@Override
	public User getById(int id) {
		return em.find(User.class, id);
	}
	
	@Override
	public List<User> getAllUser(){
		return em.createQuery("from User",User.class).getResultList();
	}
	
	@Override
	public void delete(int userId) {
		User user = em.find(User.class, userId);
		if(user!= null) {
			em.remove(user);
			System.out.println("User deleted successfully");
		}
		else 
			System.out.println("User not found");
	}
}