package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Actors;
import com.ty.entity.Movies;

public class Fetch {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Actors actors = em.find(Actors.class, 1);
		
		if(actors != null) {
			System.out.println(actors.getName());
			
			System.out.println("--------------");
			
			List<Movies> movies = actors.getMovies();
			
			for (Movies movies2 : movies) {
				System.out.println(movies2.getTitle());
			}
		}

	}

}
