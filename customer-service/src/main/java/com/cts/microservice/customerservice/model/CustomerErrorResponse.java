package com.cts.microservice.customerservice.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerErrorResponse {

	private LocalDateTime time;
	private HttpStatus status;
	private String errorMsg;
	private String message;

}
