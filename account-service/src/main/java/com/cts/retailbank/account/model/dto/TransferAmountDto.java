package com.cts.retailbank.account.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class TransferAmountDto {

	private long sourceAccountId;
	private long targetAccountId;
	private double amount;
	private double sourceClosingBalance;
	private double targetClosingBalance;
	
}
