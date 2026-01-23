package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class DeleteBank {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account account = em.find(Account.class, 22L);
		
		if(account != null) {
			et.begin();
			
			Bank bank = account.getBank();
			
			 if (bank != null) {
			        // Remove bank reference from each account
			        for (Account acc : bank.getAccounts()) {
			            acc.setBank(null);
			        }

			        // Now it is safe to delete the bank
			        em.remove(bank);
			    }
		
			
			et.commit();
		}
		
		System.out.println("Deleted");

	}

}
