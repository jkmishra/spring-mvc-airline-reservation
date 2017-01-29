package com.gamma.air.domain;

public class Offer {
	private MonetaryAmount monetayAmmount;
	private Route route;
	public MonetaryAmount getMonetayAmmount() {
		return monetayAmmount;
	}
	public void setMonetayAmmount(MonetaryAmount monetayAmmount) {
		this.monetayAmmount = monetayAmmount;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Offer [monetayAmmount=" + monetayAmmount + ", route=" + route + "]";
	}

	}
