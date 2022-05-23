package com.cognizant.retailbank.transaction.utils;

import lombok.Data;

@Data
public class DepositInput {
	private long accountId;
	private long sourceAccountId;
	private long targetAccountId;
	private float amount;
	private float balance;
}
