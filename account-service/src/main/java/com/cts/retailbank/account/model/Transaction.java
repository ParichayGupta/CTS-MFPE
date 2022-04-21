package com.cts.retailbank.account.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class Transaction {

	private boolean success;
	private long transactionId;
	private String transactionStatusCode;
	private String transactionStatusDescription;
	private LocalDateTime transactionDate;
	private float transactionAmount;
	private float closingBalance;
	private String transactionTypeCode;	
	private String transactionTypeDescription;
	private String senderAccountId;
	private String recieverAccountId;
	private float recieverClosingBalance;
	
}
