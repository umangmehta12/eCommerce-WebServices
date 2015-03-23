package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Deal;

public class DealDao {
	private static final String PERSISTENCE_UNIT_NAME = "edeal";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Deal save(Deal deal) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(deal);
		
		em.getTransaction().commit();
		em.close();

		return deal;
	}
	
	public Deal load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Deal:");
		Deal deal = em.find(Deal.class, id);
		System.out.println(deal);
		
		em.getTransaction().commit();
		em.close();
		return deal;
	}
	
	
		
	public List<Deal> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Deals:");
		List<Deal> deals = (List<Deal>)em.createNamedQuery("findAllDeals", Deal.class).getResultList();
		if(deals != null && deals.size() > 0) {
			for(Deal deal : deals)
			System.out.println(deal);
		}
		
		em.getTransaction().commit();
		em.close();
		return deals;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Deal.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Deal update(Deal deal) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(deal);
		
		em.getTransaction().commit();
		em.close();
		return deal;
	}
}
