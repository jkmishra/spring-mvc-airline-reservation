package com.gamma.air.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gamma.air.constants.Constants;
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
import com.gamma.air.repository.GammaDao;
import com.gamma.air.repository.impl.GammaDaoImpl;
import com.gamma.air.service.GammaService;
import com.gamma.air.validator.GammaValidatorUtil;

@Service
public class GammaServiceImpl implements GammaService {

	@Autowired
	private GammaDaoImpl gammaDAOImpl;

	public void setGammaDAOImpl(GammaDaoImpl gammaDAOImpl) {
		this.gammaDAOImpl = gammaDAOImpl;
	}

	public String reset(String applicationId) {
		// logic here for reset
		return applicationId;

	}

	public List<Offer> getOffer(String applicationId) {
		return new ArrayList<Offer>();
	}

	public AirlineTicket buyTicket(BuyTicket buyTicket) throws InsufficientAmmount, GammaAirException {
		GammaValidatorUtil.isSufficientAmmount(buyTicket);
		GammaValidatorUtil.validateBuyTicketRequest(buyTicket);
		return new AirlineTicket();
	}

	public List<AirlineTicket> getTickets(String applicationId) {
		return new ArrayList<AirlineTicket>();

	}

	public MonetaryAmount exchange(MoneyExchange moneyExchange) throws InvalidCurrency, GammaAirException {
		GammaValidatorUtil.isValidCurrency(moneyExchange.getTargetCurrency().toString());
		MonetaryAmount monetaryAmount = new MonetaryAmount();
		if (monetaryAmount == null)
			throw new GammaAirException(Constants.EXCHANGE_RATE_NOT_FOUND);
		return monetaryAmount;

	}

	public Account deposit(DepWithRequest depWithRequest) throws InvalidCurrency, GammaAirException {
		GammaValidatorUtil.isValidCurrency(depWithRequest.getMonetaryAmount().getCurrency().toString());
		Account account = new Account();
		if (account == null)
			throw new GammaAirException(Constants.EXCHANGE_RATE_NOT_FOUND);
		return account;
	}

	public Account withdraw(DepWithRequest depWithRequest) throws InvalidCurrency, GammaAirException {
		GammaValidatorUtil.isValidCurrency(depWithRequest.getMonetaryAmount().getCurrency().toString());
		Account account = new Account();
		if (account == null)
			throw new GammaAirException(Constants.EXCHANGE_RATE_NOT_FOUND);
		return account;
	}

	public List<com.gamma.air.model.Account> getAccounts(String applicationId) {
		return gammaDAOImpl.listAccount();
	}

	public Account createAccount(CreateAccount createAccount) throws InvalidCurrency, GammaAirException {
		GammaValidatorUtil.isValidCurrency(createAccount.getCurrency().toString());
		Account account = new Account();
		if (account == null)
			throw new GammaAirException(Constants.APPLICATION_NOT_FOUND);
		return account;

	}

	public Location selectById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long insert(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Location location) {
		// TODO Auto-generated method stub

	}

	public void delete(Location location) {
		// TODO Auto-generated method stub

	}

	public List<Flight> selectFlights(Form form) {
		// TODO Auto-generated method stub
		return null;
	}

	public Flight selectFlightById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Deal> selectDeals(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Deal> selectDealById(Integer[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
