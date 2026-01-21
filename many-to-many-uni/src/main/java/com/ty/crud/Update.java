package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actors;
import com.ty.entity.Movies;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    Actors actors = em.find(Actors.class, 2);
	    
	    if(actors != null) {
		
			List<Movies> movies = actors.getMovies();
			
			for (Movies movies2 : movies) {
				if(movies2.getMid()==12) {
					et.begin();
					movies2.setTitle("Pathaan");
					
				}else {
					System.out.println("Not Found");
				}
			}
			et.commit();

	}
	    System.out.println("Done");

	}
}
