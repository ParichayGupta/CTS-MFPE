package com.cognizant.retailbank.transaction.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(value = Include.NON_NULL)
public class FinancialTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private String accountId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Counterparty_ID")
	private Counterparties counterparties;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Payment_Method_Code")
	private RefPaymentMethods refPaymentMethods;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Service_ID")
	private Services services;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="transaction_status_code")
	private RefTransactionStatus refTransactionStatus;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="transaction_type_code")
	private RefTransactionTypes refTransactionTypes;
	private LocalDateTime dateOfTransaction;
	private String otherPartyAccountId;
	private float amountOfTransaction;
	private float closingBalance;
}
