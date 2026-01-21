package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Accounts;
import com.ty.entity.Bank;



public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		
		Bank bank = em.find(Bank.class, 11);
		
		if(bank != null) {
			System.out.println(bank.getBid());
			System.out.println(bank.getName());
			System.out.println(bank.getAddress());
			
			List<Accounts> accounts = bank.getAccounts();
			
			for (Accounts accounts2 : accounts) {
				System.out.println(accounts2.getAccountno());
				System.out.println(accounts2.getAmount());
			}
		}

		
		

	}

}
