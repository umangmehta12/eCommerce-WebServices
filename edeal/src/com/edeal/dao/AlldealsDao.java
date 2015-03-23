package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Alldeal;

public class AlldealsDao {
	public static final String PERSISTENCE_UNIT_NAME = "edeal";
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Alldeal save(Alldeal alldeal){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(alldeal);
		em.getTransaction().commit();
		em.close();
		return alldeal;
	}
	
	public Alldeal load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Alldeal:");
		Alldeal alldeal = em.find(Alldeal.class, id);
		System.out.println(alldeal);
		
		em.getTransaction().commit();
		em.close();
		return alldeal;
	}
	

		
	public List<Alldeal> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Alldeals:");
		List<Alldeal> alldeals = (List<Alldeal>)em.createNamedQuery("Alldeal.findAll", Alldeal.class).getResultList();
		if(alldeals != null && alldeals.size() > 0) {
			for(Alldeal alldeal : alldeals)
			System.out.println(alldeal);
		}
		
		em.getTransaction().commit();
		em.close();
		return alldeals;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Alldeal.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Alldeal update(Alldeal alldeal) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(alldeal);
		
		em.getTransaction().commit();
		em.close();
		return alldeal; 
	}
	
}
