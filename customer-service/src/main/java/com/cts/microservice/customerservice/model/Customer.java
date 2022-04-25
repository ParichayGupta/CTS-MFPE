package com.cts.microservice.customerservice.model;

//import java.sql.Date;
//import java.time.LocalDate;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id",unique=true)
	private int customerId;

	@NotEmpty(message = "Can't be empty")
	@Size(min = 2, message = "minimum 2 characaters required")
	@Column(name="customer_name",nullable = false)
	private String customerName;
	
	@NotEmpty
	@NotNull
	@Column(name="customer_address")
	private String address;
	
	
	@Column(name="customer_dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@NotEmpty
	@Column(name="customer_pan")
	private String panNo;
	
	
	
}



