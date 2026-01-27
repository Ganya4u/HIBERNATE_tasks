package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class Update {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Step 1: Find the Car
        Car car = em.find(Car.class, 2); // use your car ID

        if (car != null) {

            // Step 2: Get Engine (child object)
            Engine engine = car.getEngine();

            et.begin();

            // Step 3: Update Car details
            car.setBrand("BMW");
            car.setPrice(15000000);

            // Step 4: Update Engine details
            if (engine != null) {
                engine.setCc(1500); // update only fields, not ID
            }

            et.commit();

            System.out.println("Car and Engine updated successfully");
        } else {
            System.out.println("Car not found");
        }
    }
}
