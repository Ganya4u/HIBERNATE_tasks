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

//			Car car = em.find(Car.class, 1);
//
//			if (car != null) {
//			    Engine engine = car.getEngine(); // Step 1: get engine before deleting car
//
//			    et.begin();
//			    if (engine != null) {
//			        em.remove(engine);          // Step 2: delete engine first
//			    }
//			    em.remove(car);                // Step 3: delete car
//			    et.commit();
//			}
//			
//			System.out.println("Deleted");
			
			
			
			
			
			
			
			System.out.println("=============================other way");
			
			// Step 1: Find the engine by its ID
			Engine engine = em.find(Engine.class, 1); // use the Engine's ID

			if (engine != null) {
			    et.begin();
			    em.remove(engine);  // delete engine
			    et.commit();

			    System.out.println("Engine deleted");
			} else {
			    System.out.println("Engine not found");
			}

		}

	}


