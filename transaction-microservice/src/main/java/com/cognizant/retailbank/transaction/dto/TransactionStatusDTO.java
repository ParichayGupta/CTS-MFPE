package com.cognizant.retailbank.transaction.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class TransactionStatusDTO {
	private boolean success;
	private long transactionId;
	private String transactionStatusCode;
	private String transactionStatusDescription;
	private LocalDateTime transactionDate;
	private float transactionAmount;
	private String transactionTypeCode;	
	private String transactionTypeDescription;
	private String senderAccountId;
	private String recieverAccountId;
	private float closingBalance;
	private float recieverClosingBalance;
}
