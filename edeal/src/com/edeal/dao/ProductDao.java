package com.edeal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Product;

public class ProductDao {
	private static final String PERSISTENCE_UNIT_NAME = "edeal";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Product save(Product product) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(product);
		
		em.getTransaction().commit();
		em.close();

		return product;
	}
	
	public Product load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Product:");
		Product product = em.find(Product.class, id);
		System.out.println(product);
		
		em.getTransaction().commit();
		em.close();
		return product;
	}
	
	
		
	public List<Product> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Products:");
		List<Product> products = (List<Product>)em.createNamedQuery("findAllProducts", Product.class).getResultList();
		if(products != null && products.size() > 0) {
			for(Product product : products)
			System.out.println(product);
		}
		
		em.getTransaction().commit();
		em.close();
		return products;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Product.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Product update(Product product) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(product);
		
		em.getTransaction().commit();
		em.close();
		return product;
	}
}
