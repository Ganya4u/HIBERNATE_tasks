package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Accounts;
import com.ty.entity.Bank;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bank bank = new Bank(22,"HDFC", "Pune");
		
		Accounts a1 = new Accounts(441, 500);
		Accounts a2 = new Accounts(442, 600);
		Accounts a3 = new Accounts(443, 900);
		
		bank.setAccounts(Arrays.asList(a1,a2,a3));
		
		et.begin();
		em.persist(bank);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		et.commit();

		System.out.println("saved");
		

	}

}
