package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {
	
	@Id
	private int id ;
	private String msg ;
	
	@ManyToOne
	private Product product ;

	public Reviews() {
		
	}

	public Reviews(int id, String msg) {
		
		this.id = id;
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
