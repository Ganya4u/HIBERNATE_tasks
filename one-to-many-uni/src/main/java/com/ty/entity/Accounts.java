package com.ty.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
	
	@Id
	private long accountno ;
	
	private double amount ;

	public Accounts() {
		
	}

	public Accounts(long accountno, double amount) {
		this.accountno = accountno;
		this.amount = amount;
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
