package com.ty.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Actors;
import com.ty.entity.Movies;

public class Delete2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Actors actors = em.find(Actors.class, 3);
		
		if(actors != null) {
			List<Movies> movies = actors.getMovies();
			
			List<Movies> moviesCopy = new ArrayList<>(movies);
			
			et.begin();
			
			for (Movies movies2 :  moviesCopy) {
				
				if(movies2.getTitle().equals("Pushpa")) {
					
					actors.getMovies().remove(movies2);  // First remove the movie from the actor's collection
					
					em.remove(movies2);    // Then remove it from the database
				}
				
			}
			et.commit();
		}
		
		
		System.out.println("Deleted");
	}

}
