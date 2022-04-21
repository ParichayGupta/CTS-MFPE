package com.cts.retailbank.account.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.retailbank.account.exception.AccountNotFoundException;
import com.cts.retailbank.account.exception.TransactionNotFoundException;
import com.cts.retailbank.account.model.AccountErrorResponse;

@RestControllerAdvice
public class AccountErrorController {

	@ExceptionHandler({AccountNotFoundException.class})
	public ResponseEntity<AccountErrorResponse> handleAccountNotFoundException(AccountNotFoundException exception){
		AccountErrorResponse errorResponse = new AccountErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, exception.getMessage(), "Account not found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({TransactionNotFoundException.class})
	public ResponseEntity<AccountErrorResponse> handleTransactionNotFoundException(TransactionNotFoundException exception){
		AccountErrorResponse errorResponse = new AccountErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, exception.getMessage(), "Transaction not found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
