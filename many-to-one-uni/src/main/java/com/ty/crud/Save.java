package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Reviews;

public class Save {

	public static void main(String[] args) {

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Product product = new Product(2, "Oil", 400);
		
		Reviews r1 = new Reviews(4, "Bad");
		Reviews r2 = new Reviews(5, "Good");
		Reviews r3 = new Reviews(6, "Overrated");
		
		r1.setProduct(product);
		r2.setProduct(product);
		r3.setProduct(product);
		
		et.begin();
		
		em.persist(product);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		
		et.commit();
		
		System.out.println("Saved Success");

	}

}
