package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actors;



public class Delete {

	public static void main(String[] args) {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			Actors actors = em.find(Actors.class, 1);
			
			if(actors != null) {
				et.begin();
				em.remove(actors);
				et.commit();
			}
			
			
			System.out.println("Deleted");
		}

	}


