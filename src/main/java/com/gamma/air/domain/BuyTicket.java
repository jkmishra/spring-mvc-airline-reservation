package com.gamma.air.domain;

public class BuyTicket {
	private String accountId;
	private int ammount;
	private Route route;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "BuyTicket [accountId=" + accountId + ", ammount=" + ammount + ", route=" + route + "]";
	}
	

}
