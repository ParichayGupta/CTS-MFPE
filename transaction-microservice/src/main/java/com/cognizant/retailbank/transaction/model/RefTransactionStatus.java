package com.cognizant.retailbank.transaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class RefTransactionStatus { 
	@Id
	private String transactionStatusCode;
	private String transactionStatusDescription;
}
