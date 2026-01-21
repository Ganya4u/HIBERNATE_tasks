package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Bank;



public class Delete2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bank bank = em.find(Bank.class, 11);
		
		if(bank != null) {
			et.begin();
			em.remove(bank);
			et.commit();
			
			System.out.println("===========");
			
			
		}
		
		System.out.println("Deleted");

	}

}
