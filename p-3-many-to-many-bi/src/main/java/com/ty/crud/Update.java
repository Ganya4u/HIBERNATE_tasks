package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    Movie movie = em.find(Movie.class, 2);
	    
	    if(movie != null) {
	    	et.begin();
	    	
	    	List<Actor> actors = movie.getActors();
	    	for (Actor actor : actors) {
	    		
	    		if(actor.getId()==22) {
	    			actor.setName("Naya Khan");
	    		}
				
			}
	    	
	    	et.commit();
	    }
	    
	    System.out.println("Updated");
	    

	}

}
