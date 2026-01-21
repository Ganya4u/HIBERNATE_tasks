package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Reviews;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Reviews reviews = em.find(Reviews.class, 1);
		
		if(reviews != null) {
			et.begin();
			em.remove(reviews);
			et.commit();
		}
		
		
		System.out.println("Deleted");
	}

}
