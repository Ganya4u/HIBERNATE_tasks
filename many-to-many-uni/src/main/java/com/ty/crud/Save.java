package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actors;
import com.ty.entity.Movies;

public class Save {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Actors a1 = new Actors(1, "Salman Khan");
//		Actors a2 = new Actors(2, "Shaharukh Khan");
		Actors a3 = new Actors(3, "Allu Arjun");
		
		Movies m1 = new Movies(31,"Arya");
		Movies m2 = new Movies(32,"Pushpa");
//		Movies m2 = em.find(Movies.class, 12); // for srk ....and sallu karan arjun
		
		
		a3.setMovies(Arrays.asList(m1,m2));
		
		et.begin();
	    em.persist(a3);
	    em.persist(m1);
	    em.persist(m2);
	    et.commit();
	    
	    System.out.println("Saved");
		
		
		

	}

}
