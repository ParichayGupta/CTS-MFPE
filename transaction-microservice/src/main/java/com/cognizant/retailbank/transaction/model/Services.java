package com.cognizant.retailbank.transaction.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	private LocalDate dateServiceProvided;
}
