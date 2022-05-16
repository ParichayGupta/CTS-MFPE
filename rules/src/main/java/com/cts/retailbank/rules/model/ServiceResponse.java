package com.cts.retailbank.rules.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {

	// The output format for Service Charge
	private String message;
	private long accountId;
	private double balance;
}
