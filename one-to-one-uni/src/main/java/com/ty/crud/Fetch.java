package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Car car = em.find(Car.class, 3);
		
		if(car != null) {
			
			System.out.println(car.getCid());
			System.out.println(car.getBrand());
			System.out.println(car.getPrice());
			
			System.out.println("===================");
			
			Engine engine = car.getEngine();
			
			System.out.println(engine.getEid());
			System.out.println(engine.getCc());
		}


	}

}
