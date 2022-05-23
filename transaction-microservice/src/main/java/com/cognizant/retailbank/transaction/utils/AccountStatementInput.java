package com.cognizant.retailbank.transaction.utils;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementInput {
	private String accountId;
	private LocalDate startDate;
	private LocalDate endDate;
}
