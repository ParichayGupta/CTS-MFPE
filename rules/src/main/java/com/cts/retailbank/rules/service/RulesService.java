package com.cts.retailbank.rules.service;

import com.cts.retailbank.rules.model.RulesInput;
import com.cts.retailbank.rules.model.ServiceResponse;

public interface RulesService {

	public boolean evaluateBalance(RulesInput account);

	public ServiceResponse serviceCharges(RulesInput account);

}
