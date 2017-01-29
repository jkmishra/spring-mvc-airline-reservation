package com.gamma.air.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamma.air.constants.Constants;
import com.gamma.air.domain.Account;
import com.gamma.air.domain.AirlineTicket;
import com.gamma.air.domain.BuyTicket;
import com.gamma.air.domain.CreateAccount;
import com.gamma.air.domain.Deal;
import com.gamma.air.domain.DepWithRequest;
import com.gamma.air.domain.ErrorResponse;
import com.gamma.air.domain.Flight;
import com.gamma.air.domain.MonetaryAmount;
import com.gamma.air.domain.MoneyExchange;
import com.gamma.air.domain.Offer;
import com.gamma.air.exception.GammaAirException;
import com.gamma.air.exception.InsufficientAmmount;
import com.gamma.air.exception.InvalidCurrency;
import com.gamma.air.forms.Form;
import com.gamma.air.service.GammaService;
import com.gamma.air.service.LocationService;
import com.gamma.air.validator.SearchValidator;

@Controller
public class GammaAirController {
	private Logger logger = LoggerFactory.getLogger(GammaAirController.class);

	@Autowired
	private LocationService locationService;
	@Autowired
	private GammaService gammaService;
	private SearchValidator validator;

	private List<AirlineTicket> tickets;

	public SearchValidator getValidator() {
		return validator;
	}

	@Autowired
	public void setValidator(SearchValidator validator) {
		this.validator = validator;
	}

	@RequestMapping(value = "/{applicantId}/reset", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE })

	public @ResponseBody ResponseEntity reset(@PathVariable String applicationId) {
		String resetResp = null;
		// reset logic
		resetResp = gammaService.reset(applicationId);

		if (resetResp != null || resetResp.equalsIgnoreCase("SUCCESS")) {

			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity(new ErrorResponse(Constants.APPLICATION_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{applicantId}/gammaairlines/offers", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<List<Offer>> getOffer(@PathVariable String applicationId) {
		// offer logic
		List<Offer> offers = gammaService.getOffer(applicationId);

		if (offers != null) {

			return new ResponseEntity<List<Offer>>(offers, HttpStatus.OK);
		} else
			return new ResponseEntity(new ErrorResponse(Constants.APPLICATION_NOT_FOUND), HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/{applicantId}/gammaairlines/tickets/buy", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<AirlineTicket> buyTicket(@RequestBody BuyTicket buyTicket,
			@PathVariable String applicationId) {

		AirlineTicket airlineTicket;
		try {
			airlineTicket = gammaService.buyTicket(buyTicket);
		} catch (InsufficientAmmount e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (GammaAirException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}

			return new ResponseEntity<AirlineTicket>(airlineTicket, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{applicantId}/gammaairlines/tickets", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<AirlineTicket>> getTickets(@PathVariable String applicationId) {
		List<AirlineTicket> tickets = gammaService.getTickets(applicationId);
		if (tickets != null) {
			return new ResponseEntity<List<AirlineTicket> >(tickets, HttpStatus.OK);
		} else
			return new ResponseEntity(new ErrorResponse(Constants.APPLICATION_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{applicantId}/moneyexchange/exchange", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<MonetaryAmount> exchange(@RequestBody MoneyExchange moneyExchange, @PathVariable String applicationId) {
		MonetaryAmount exchange;
		try {
			exchange = gammaService.exchange(moneyExchange);
		} catch (InvalidCurrency e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (GammaAirException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<MonetaryAmount>(exchange,HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{applicantId}/paypallets/account/deposit", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<Account> deposit(@RequestBody DepWithRequest depWithRequest, @PathVariable String applicationId) {
		Account deposit=null;
		 try {
			 deposit = gammaService.deposit(depWithRequest);
		}  catch (InvalidCurrency e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (GammaAirException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<Account>(deposit,HttpStatus.OK);
	
	}

	@RequestMapping(value = "/{applicantId}/paypallets/account/withdraw", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<Account> withdraw(@RequestBody DepWithRequest depWithRequest, @PathVariable String applicationId) {
		Account withdraw=null;
		 try {
			 withdraw = gammaService.withdraw(depWithRequest);
		}  catch (InvalidCurrency e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (GammaAirException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<Account>(withdraw,HttpStatus.OK);
	
	}

	
	@RequestMapping(value = "/{applicantId}/paypallets/accounts", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public @ResponseBody ResponseEntity<List<com.gamma.air.model.Account>> accounts(@PathVariable String applicantId) {

		List<com.gamma.air.model.Account> accounts = gammaService.getAccounts(applicantId);
		if (accounts != null) {
			return new ResponseEntity<List<com.gamma.air.model.Account> >(accounts, HttpStatus.OK);
		} else
			return new ResponseEntity(new ErrorResponse(Constants.APPLICATION_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}
	

	@RequestMapping(value = "/{applicantId}/paypallets/account", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<Account>createAccount(@RequestBody CreateAccount createAccount, @PathVariable String applicationId) {
		Account account=null;
		 try {
			 account = gammaService.createAccount(createAccount);
		}  catch (InvalidCurrency e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (GammaAirException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<Account>(account,HttpStatus.OK);
	

	}

	
	
	
	
	@RequestMapping(value = "searchResultsJson", method = RequestMethod.GET)
	public @ResponseBody List<Flight> searchResultsJson(@RequestParam String leavingFrom, @RequestParam String goingTo,
			@RequestParam String startDate, @RequestParam String endDate) {
		Form form = new Form();

		form.setOrigin(leavingFrom);
		form.setDestination(goingTo);
		form.setStartDate(startDate);
		form.setReturnDate(endDate);

		return locationService.selectFlights(form);
	}

	@RequestMapping(value = "deals/{code}", method = RequestMethod.GET)
	public @ResponseBody List<Deal> deals(@PathVariable String code) {

		return locationService.selectDeals(code);
	}
}
