package com.cts.retailbank.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "balance")
	private double balance = 2500.00;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "acc_holder_name")
	private String accHolderName;
	
}
