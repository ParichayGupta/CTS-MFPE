package com.cts.retailbank.rules.service;

import org.springframework.stereotype.Service;

import com.cts.retailbank.rules.model.RulesInput;
import com.cts.retailbank.rules.model.ServiceResponse;

@Service
public class RulesServiceImpl implements RulesService {

	private static final int MINIMUM_BALANCE = 2500;

	@Override
	public boolean evaluateBalance(RulesInput account) {

		if (MINIMUM_BALANCE <= account.getCurrentBalance()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ServiceResponse serviceCharges(RulesInput account) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setAccountId(account.getAccountId());

		// Checking Balance
		if (account.getCurrentBalance() < MINIMUM_BALANCE) {
			double deducted = account.getCurrentBalance() / 10;
			serviceResponse.setMessage("Your Balance is lesser than the minimum required balance. So amount of \\u20B9"
					+ deducted + " is deducted from your account.");
			serviceResponse.setBalance(account.getCurrentBalance() - deducted);
		} else {
			serviceResponse.setMessage("No deduction");
			serviceResponse.setBalance(account.getCurrentBalance());
		}
		return serviceResponse;
	}

}
