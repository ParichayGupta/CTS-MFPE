package com.cts.microservice.customerservice.util;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInput {
	
	
	private int id;
	@NotEmpty(message = "Can't be empty")
	@Size(min = 2, message = "minimum 2 characaters required")
	private String name;
	
	@NotEmpty
	@NotNull
	private String address;
	@NotEmpty
	private String pan_no;
	
	
	private LocalDate dob;
	

	private String accountType;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	
	

}
