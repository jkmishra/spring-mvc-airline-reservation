package com.gamma.air.service;

import java.util.List;

import com.gamma.air.domain.Account;
import com.gamma.air.domain.AirlineTicket;
import com.gamma.air.domain.BuyTicket;
import com.gamma.air.domain.CreateAccount;
import com.gamma.air.domain.Deal;
import com.gamma.air.domain.DepWithRequest;
import com.gamma.air.domain.Flight;
import com.gamma.air.domain.Location;
import com.gamma.air.domain.MonetaryAmount;
import com.gamma.air.domain.MoneyExchange;
import com.gamma.air.domain.Offer;
import com.gamma.air.exception.GammaAirException;
import com.gamma.air.exception.InsufficientAmmount;
import com.gamma.air.exception.InvalidCurrency;
import com.gamma.air.forms.Form;

public interface GammaService {
	
	
	String reset(String applicationId);
	List<Offer> getOffer(String applicationId);
	AirlineTicket buyTicket(BuyTicket buyTicket) throws InsufficientAmmount,GammaAirException;
	List<AirlineTicket> getTickets(String applicationId);
	MonetaryAmount exchange(MoneyExchange moneyExchange) throws InvalidCurrency,GammaAirException;
	Account deposit(DepWithRequest depWithRequest) throws InvalidCurrency,GammaAirException;
	Account withdraw(DepWithRequest depWithRequest)throws InvalidCurrency,GammaAirException;
	Account createAccount(CreateAccount createAccount)throws InvalidCurrency,GammaAirException;
	List<com.gamma.air.model.Account> getAccounts(String applicationId);	
  Location selectById(long id);

  List<Location> selectAll();

  Long insert(Location location);

  void update(Location location);

  void delete(Location location);
  
  List<Flight> selectFlights(Form form);
  
  Flight selectFlightById(Integer id);
  
  List<Deal> selectDeals(String code);
  
  List<Deal> selectDealById(Integer[] ids);



}
