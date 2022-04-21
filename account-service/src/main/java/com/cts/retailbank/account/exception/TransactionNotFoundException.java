package com.cts.retailbank.account.exception;

public class TransactionNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException(String message) {
		super(message);
	}
}
