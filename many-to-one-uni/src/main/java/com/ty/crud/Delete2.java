package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Reviews;

public class Delete2 {

	public static void main(String[] args) {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			Reviews reviews = em.find(Reviews.class, 2);
			
			if(reviews != null) {
				Product product = reviews.getProduct();
				et.begin();
				em.remove(product);  // not possible 1st delete each and every record then delete product
				et.commit();
			}
			
			
			System.out.println("Deleted");
		}

	}


