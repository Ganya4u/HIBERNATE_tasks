package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Account account = em.find(Account.class, 31L);
        
        if(account != null) {
        	et.begin();
        	
        	Bank bank = account.getBank();
        	
        	bank.setAddress("Chennai");
        	
        	et.commit();
        }
        
        System.out.println("Done");

	}

}
