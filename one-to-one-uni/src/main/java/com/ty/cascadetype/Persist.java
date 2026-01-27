package com.ty.cascadetype;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class Persist {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
          Car car = new Car(8,"Dhoom", 701700000);
		
		  Engine engine = new Engine(8, 7877);
		
		   car.setEngine(engine);
		
		   et.begin();

	      em.persist(car);
		
		et.commit();

		System.out.println("saved");

		

	}

}
