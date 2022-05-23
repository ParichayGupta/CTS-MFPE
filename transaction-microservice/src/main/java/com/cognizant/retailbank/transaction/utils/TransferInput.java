package com.cognizant.retailbank.transaction.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferInput {
	private String sourceAccountId;
	private String targetAccountId;
	private float amount;
	private float sourceClosingBalance;
	private float targetClosingBalance;
}
