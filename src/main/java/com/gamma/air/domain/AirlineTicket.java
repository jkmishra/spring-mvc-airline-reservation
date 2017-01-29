package com.gamma.air.domain;

public class AirlineTicket {
private int ammount;
private Offer detail;
public int getAmmount() {
	return ammount;
}
public void setAmmount(int ammount) {
	this.ammount = ammount;
}
public Offer getDetail() {
	return detail;
}
public void setDetail(Offer detail) {
	this.detail = detail;
}
@Override
public String toString() {
	return "AirlineTicket [ammount=" + ammount + ", detail=" + detail + "]";
}

}
