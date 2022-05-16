package com.cts.retailbank.rules.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RulesInput {
	
	private long accountId;
	private double currentBalance;
	
}
