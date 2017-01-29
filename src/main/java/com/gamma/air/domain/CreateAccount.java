package com.gamma.air.domain;

public class CreateAccount {
	private Currency currency;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "CreateAccount [currency=" + currency + "]";
	}
	

}
