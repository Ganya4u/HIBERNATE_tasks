package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Accounts;
import com.ty.entity.Bank;

public class Update {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();
	        

			Bank bank = em.find(Bank.class, 11);
			
			if(bank != null) {
				List<Accounts> accounts = bank.getAccounts();
				et.begin();
				for (Accounts accounts2 : accounts) {
					if (accounts2.getAccountno()==333) {
						accounts2.setAmount(777);
				}
					
					
				
				}
				bank.setName("rk");
				et.commit();
			}
			
			
			System.out.println("Updated");


	}

}
