package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Producer;
public class ProducerDao {
	public static final String PERSISTENCE_UNIT_NAME = "edeal";
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Producer save(Producer producer){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(producer);
		em.getTransaction().commit();
		em.close();
		return producer;
	}
	
	public Producer load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Producer:");
		Producer producer = em.find(Producer.class, id);
		System.out.println(producer);
		
		em.getTransaction().commit();
		em.close();
		return producer;
	}
	
	
		
	public List<Producer> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Producers:");
		List<Producer> producers = (List<Producer>)em.createNamedQuery("findAllProducers", Producer.class).getResultList();
		if(producers != null && producers.size() > 0) {
			for(Producer producer : producers)
			System.out.println(producer);
		}
		
		em.getTransaction().commit();
		em.close();
		return producers;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Producer.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Producer update(Producer producer) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(producer);
		
		em.getTransaction().commit();
		em.close();
		return producer;
	}
	
	
}
