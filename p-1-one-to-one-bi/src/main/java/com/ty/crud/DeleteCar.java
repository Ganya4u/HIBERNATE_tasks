package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class DeleteCar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine engine = em.find(Engine.class, 12);
		
		if(engine != null) {
			et.begin();
			Car car = engine.getCar();
			
			if(car != null) {
				 car.setEngine(null);
				em.remove(car);
			}
			et.commit();
		}
		
		System.out.println("Deleted");

	}

}
