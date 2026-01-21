package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Reviews;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Reviews reviews = em.find(Reviews.class, 1);
		
		if(reviews != null) {
			System.out.println(reviews.getId());
			System.out.println(reviews.getMsg());
			
			System.out.println("==========");
			
			Product product = reviews.getProduct();
			
			System.out.println(product.getPid());
			System.out.println(product.getPname());
			System.out.println(product.getPrice());
		}

	}

}
