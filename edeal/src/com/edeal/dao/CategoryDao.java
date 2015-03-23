package com.edeal.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edeal.base.Category;

public class CategoryDao{
	
	public static final String PERSISTENCE_UNIT_NAME = "edeal";
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public Category save(Category category){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		em.close();
		return category;
	}
	
	public Category load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading Category:");
		Category category = em.find(Category.class, id);
		System.out.println(category);
		
		em.getTransaction().commit();
		em.close();
		return category;
	}
	

		
	public List<Category> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Loading All Categorys:");
		List<Category> categorys = (List<Category>)em.createNamedQuery("findAllCategories", Category.class).getResultList();
		if(categorys != null && categorys.size() > 0) {
			for(Category category : categorys)
			System.out.println(category);
		}
		
		em.getTransaction().commit();
		em.close();
		return categorys;
	}
	
	public void remove(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.remove(em.getReference(Category.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Category update(Category category) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.merge(category);
		
		em.getTransaction().commit();
		em.close();
		return category;
	}
	

	


}
