package com.cts.microservice.customerservice.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.microservice.customerservice.exception.CustomerNotFoundException;
import com.cts.microservice.customerservice.model.CustomerErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomerErrorController {

	@ExceptionHandler({CustomerNotFoundException.class})
	public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException exception){
	CustomerErrorResponse errorResponse = new CustomerErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, exception.getMessage(), "Customer doesn't exist.");
	return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	}
 
















