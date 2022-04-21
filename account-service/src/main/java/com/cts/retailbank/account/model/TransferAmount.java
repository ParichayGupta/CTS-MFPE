package com.cts.retailbank.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferAmount {

	private long sourceAccountId;
	private long targetAccountId;
	private double amount;
	
}
