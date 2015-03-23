package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Preferredsite;

public class PreferredsiteDao {
	public static final String PERSISTENCE_UNIT_NAME = "edeal";
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Preferredsite save(Preferredsite preferredsite){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(preferredsite);
		em.getTransaction().commit();
		em.close();
		return preferredsite;
	}
	
	public Preferredsite load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Preferredsite:");
		Preferredsite preferredsite = em.find(Preferredsite.class, id);
		System.out.println(preferredsite);
		
		em.getTransaction().commit();
		em.close();
		return preferredsite;
	}
	

		
	public List<Preferredsite> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Preferredsites:");
		List<Preferredsite> preferredsites = (List<Preferredsite>)em.createNamedQuery("findAllPreferredsites", Preferredsite.class).getResultList();
		if(preferredsites != null && preferredsites.size() > 0) {
			for(Preferredsite preferredsite : preferredsites)
			System.out.println(preferredsite);
		}
		
		em.getTransaction().commit();
		em.close();
		return preferredsites;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Preferredsite.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Preferredsite update(Preferredsite preferredsite) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(preferredsite);
		
		em.getTransaction().commit();
		em.close();
		return preferredsite;
	}
	
	
}
