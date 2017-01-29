package com.gamma.air.validator;

import java.util.Arrays;

import com.gamma.air.constants.Constants;
import com.gamma.air.domain.BuyTicket;
import com.gamma.air.domain.Currency;
import com.gamma.air.domain.Route;
import com.gamma.air.exception.GammaAirException;
import com.gamma.air.exception.InsufficientAmmount;
import com.gamma.air.exception.InvalidCurrency;

public class GammaValidatorUtil {
	public static void validateBuyTicketRequest(BuyTicket buyTicket) throws GammaAirException {
		// TODO Auto-generated method stub
		if (buyTicket.getAccountId() == null || !isAccountExist(buyTicket.getAccountId())
				|| !isValidRoute(buyTicket.getRoute()))
			throw new GammaAirException(Constants.GAMMA_TICKET_BUY_EXCEPTION);
	}

	private static boolean isValidRoute(Route route) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isAccountExist(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isValidCurrency(String currency) throws InvalidCurrency {
		// TODO Auto-generated method stub
		if (Arrays.asList(Currency.values()).contains(Currency.valueOf(currency)))
			return true;
		else
			throw new InvalidCurrency(Constants.INVALID_CURRENCY);
	}

	public static boolean isSufficientAmmount(BuyTicket buyTicket) throws InsufficientAmmount {
		// TODO Auto-generated method stub
		if (buyTicket.getAmmount() <= 0)
			throw new InsufficientAmmount(Constants.INSUFFICIENT_AMMOUNT);
		return true;
	}
}
