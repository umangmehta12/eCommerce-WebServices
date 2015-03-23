package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Usertype;

public class UsertypeDao {
	public static final String PERSISTENCE_UNIT_NAME = "edeal";
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Usertype save(Usertype usertype){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(usertype);
		em.getTransaction().commit();
		em.close();
		return usertype;
	}
	
	public Usertype load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Usertype:");
		Usertype usertype = em.find(Usertype.class, id);
		System.out.println(usertype);
		
		em.getTransaction().commit();
		em.close();
		return usertype;
	}
	
	
		
	public List<Usertype> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Usertypes:");
		List<Usertype> usertypes = (List<Usertype>)em.createNamedQuery("findAllUsertypes", Usertype.class).getResultList();
		if(usertypes != null && usertypes.size() > 0) {
			for(Usertype usertype : usertypes)
			System.out.println(usertype);
		}
		
		em.getTransaction().commit();
		em.close();
		return usertypes;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Usertype.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Usertype update(Usertype usertype) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(usertype);
		
		em.getTransaction().commit();
		em.close();
		return usertype;
	}
	


}
