package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Employee;

public class Fetch {

	public static void main(String[] args) {
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		EntityManager em = emf.createEntityManager();
		
		Employee emp = em.find(Employee.class, 104);
		
		if (emp != null) {
			System.out.println(emp.getEid());
			System.out.println(emp.getEname());
			System.out.println(emp.getEsalary());
		} else {
			System.out.println("Not Found");
		}

	}

}
