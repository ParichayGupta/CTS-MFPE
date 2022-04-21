package com.cts.retailbank.account.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class CustomerAccountDto {

	private long accountId;
	private String accountType;
	private double balance;
}
