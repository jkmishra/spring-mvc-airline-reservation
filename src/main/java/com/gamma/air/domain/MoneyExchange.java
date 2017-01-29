package com.gamma.air.domain;

public class MoneyExchange {
	private MonetaryAmount monetayAmmount;
	private Currency targetCurrency;
	public MonetaryAmount getMonetayAmmount() {
		return monetayAmmount;
	}
	public void setMonetayAmmount(MonetaryAmount monetayAmmount) {
		this.monetayAmmount = monetayAmmount;
	}
	public Currency getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	@Override
	public String toString() {
		return "MoneyExchange [monetayAmmount=" + monetayAmmount + ", targetCurrency=" + targetCurrency + "]";
	}
	

}
