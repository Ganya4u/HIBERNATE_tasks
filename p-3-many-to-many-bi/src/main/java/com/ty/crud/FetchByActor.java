package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Actor;
import com.ty.entity.Movie;

public class FetchByActor {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Actor actor = em.find(Actor.class, 12);

		if (actor != null) {
			System.out.println("=======Actor==========");
			System.out.println(actor.getId());
			System.out.println(actor.getName());
			

			System.out.println("----------Movies--------");
			List<Movie> movies = actor.getMovies();
			for (Movie movie : movies) {
				System.out.println(movie.getMid());
				System.out.println(movie.getTitle());
				
			}
		} else {
			System.out.println("not found");
		}

	}

}
