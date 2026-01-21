package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Accounts;
import com.ty.entity.Bank;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank bank = em.find(Bank.class, 11);
		
		if(bank != null) {
			List<Accounts> accounts = bank.getAccounts();
			
			 // Find the account to delete
            Accounts accountToDelete = null;
            for (Accounts a : accounts) {
                if (a.getAccountno() == 331) {
                    accountToDelete = a;
                    break;
                }
            }

            // Delete safely
            if (accountToDelete != null) {
                et.begin();
                bank.getAccounts().remove(accountToDelete); // remove reference from bank
                em.remove(accountToDelete); // remove from DB
                et.commit();
                System.out.println("Deleted account 331 successfully");
            } else {
                System.out.println("Account 331 not found!");
            }
            
            
            
		}
		
		System.out.println("Deleted");


	}

}
