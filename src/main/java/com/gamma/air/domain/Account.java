package com.gamma.air.domain;

public class Account {
	private MonetaryAmount balance;
	private String id;
	public MonetaryAmount getBalance() {
		return balance;
	}
	public void setBalance(MonetaryAmount balance) {
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + "]";
	}

}
