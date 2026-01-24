package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class DeleteActor {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		

		Movie movie = em.find(Movie.class, 3);
		
		 if(movie != null) {
		    	et.begin();
		    	
		    	List<Actor> actors = movie.getActors();
		    	 Actor actorToDelete = null;
		    	 
		    	for (Actor actor : actors) {
		    		
		    		if(actor.getId()==32) {
		    			  actorToDelete = actor;
		    	            break;
		    		}
					
				}
		    	
		    	 if (actorToDelete != null) {
		    	        
		    	        actors.remove(actorToDelete); // breaks the foreign key relationship

		    	        em.remove(actorToDelete);  //Deletes the actor row
		    	    }
		    	
		    	et.commit();
		    }
		 
		 
		 System.out.println("Deleted");
		    

	}

}
