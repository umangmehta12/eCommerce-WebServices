package com.edeal.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.edeal.base.User;

public class UserDao {
	private static final String PERSISTENCE_UNIT_NAME = "edeal";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public User save(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(user);
		
		em.getTransaction().commit();
		em.close();

		return user;
	}
	
	public User load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading User:");
		User user = em.find(User.class, id);
		System.out.println(user);
		
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
			
	public List<User> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Users:");
		List<User> users = (List<User>)em.createNamedQuery("findAllUsers", User.class).getResultList();
		if(users != null && users.size() > 0) {
			for(User user : users)
			System.out.println(user);
		}
		
		em.getTransaction().commit();
		em.close();
		return users;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(User.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public User update(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(user);
		
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
}
