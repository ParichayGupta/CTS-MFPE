package com.cts.retailbank.account.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class TransactionAmountDto {

	private long accountId;
	private double amount;
	private double balance;
	
}
