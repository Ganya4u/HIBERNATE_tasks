package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int pid ;
    private String pname ;
    private double price ;
    
    public Product() {
		
	}
    
	public Product(int pid, String pname, double price) {
		
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
    
    
    

}
