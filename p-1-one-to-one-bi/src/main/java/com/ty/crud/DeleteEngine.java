package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class DeleteEngine {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, 1);
		
		if (car != null) {
	    et.begin();
	    Engine engine = car.getEngine(); // Step 1: get engine before deleting car
		    if (engine != null) {
		    car.setEngine(null);  //Break association
	        em.remove(engine);          // Step 2: delete engine first
		    }
	               
		    et.commit();
		}
		
		System.out.println("Deleted");

	}

}
