package com.cognizant.retailbank.transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Counterparties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int counterpartyId;
	private String counterpartyName;
}
