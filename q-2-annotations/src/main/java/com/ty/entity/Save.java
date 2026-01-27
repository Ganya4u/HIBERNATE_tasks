package com.ty.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User user = new User();
		user.setName("Rah");
		user.setEmail("Rahu@gmail.com");
		user.setPhone(886);
		user.setPassword("Rahu@123");

		
		et.begin();
		em.persist(user);
		et.commit();

		System.out.println("table created");

	}

}
