package com.cts.retailbank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.retailbank.account.exception.AccountNotFoundException;
import com.cts.retailbank.account.exception.TransactionNotFoundException;
import com.cts.retailbank.account.model.Account;
import com.cts.retailbank.account.model.AccountCreationStatus;
import com.cts.retailbank.account.model.Transaction;
import com.cts.retailbank.account.model.TransactionAmount;
import com.cts.retailbank.account.model.TransferAmount;
import com.cts.retailbank.account.model.dto.CustomerAccountDto;
import com.cts.retailbank.account.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping("/create-account")
	public AccountCreationStatus createAccount(@RequestBody Account acc) {
		AccountCreationStatus accountCreationStatus = service.createAccount(acc);
		log.info("Account Created successfully");
		return accountCreationStatus;
	}
	
	@GetMapping("/get_cust_acc/{custId}")
	public List<CustomerAccountDto> getCustomerAccounts(@PathVariable long custId){
		List<CustomerAccountDto> customerAccountDtoList = service.getCustomerAccounts(custId);
		log.info("Customer Account fetched");
		return customerAccountDtoList;
	}
	
	@GetMapping("/get_acc/{accId}")
	public CustomerAccountDto getAccount(@PathVariable long accId) throws AccountNotFoundException {
		CustomerAccountDto customerAccountDto = service.getAccount(accId);
		log.info("Account fetched");
		return customerAccountDto;
	}
	
	@PostMapping("/deposit")
	public Transaction deposit(@RequestBody TransactionAmount transactionAmount) {
		Transaction transaction = service.deposit(transactionAmount);
		log.info("deposit proceed");
		return transaction;
	}
	
	@PostMapping("/withdraw")
	public Transaction withdrow(@RequestBody TransactionAmount transactionAmount) {
		Transaction transaction = service.withdraw(transactionAmount);
		log.info("withdraw proceed");
		return transaction;
	}
	
	@GetMapping("/account-statement")
	public List<Transaction> getAccountStatement(@RequestParam long accountId, String fromDate, String toDate) throws TransactionNotFoundException {
		List<Transaction> transactionList = service.getAccountStatement(accountId, fromDate, toDate);
		log.info("Showing Account Statements");
		return transactionList;
	}
	
	@PostMapping("/transfer")
	public Transaction transfer(@RequestBody TransferAmount transferAmount) throws AccountNotFoundException {
		Transaction transaction = service.transfer(transferAmount);
		log.info("transfer initiated");
		return transaction;
	}
}
