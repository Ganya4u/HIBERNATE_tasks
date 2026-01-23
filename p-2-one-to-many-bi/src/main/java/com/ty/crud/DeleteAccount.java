package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class DeleteAccount {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bank bank = em.find(Bank.class, 1);
		
		if(bank != null) {
			et.begin();
			
			List<Account> accounts = bank.getAccounts();
			
			for (Account account : accounts) {
				if(account.getAccno()==12) {
					account.setBank(null);
					em.remove(account);
				}
			}
			
			et.commit();
		}

	}

}
