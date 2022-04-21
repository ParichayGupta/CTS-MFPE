package com.cts.retailbank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.retailbank.account.exception.AccountNotFoundException;
import com.cts.retailbank.account.exception.TransactionNotFoundException;
import com.cts.retailbank.account.model.Account;
import com.cts.retailbank.account.model.AccountCreationStatus;
import com.cts.retailbank.account.model.Transaction;
import com.cts.retailbank.account.model.TransactionAmount;
import com.cts.retailbank.account.model.dto.CustomerAccountDto;
import com.cts.retailbank.account.model.dto.TransactionAmountDto;
import com.cts.retailbank.account.model.dto.TransferAmountDto;
import com.cts.retailbank.account.repository.AccountRepo;
import com.cts.retailbank.account.model.TransferAmount;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountService {

	@Autowired
	AccountRepo repo;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	TransactionAmountDto transactionAmountDto;
	
	@Autowired
	TransferAmountDto transferAmountDto;
	
	@Transactional
	public AccountCreationStatus createAccount(Account acc) {
		if(repo.save(acc) != null) {
			return new AccountCreationStatus(acc.getAccountId(), "Account created successfully");
		}
		return new AccountCreationStatus(acc.getAccountId(), "Account not created"); 
	}
	
	@Transactional
	public List<CustomerAccountDto> getCustomerAccounts(long custId){
		List<Account> accList =  repo.getAccountByCustomerId(custId);
		List<CustomerAccountDto> custDto = new ArrayList<>();
		for(Account acc: accList) {
			custDto.add(new CustomerAccountDto(acc.getAccountId(), acc.getAccountType(), acc.getBalance()));
		}
		return custDto;
	}
	
	@Transactional
	public CustomerAccountDto getAccount(long accId) throws AccountNotFoundException {
		Account acc = repo.getAccountByAccountId(accId);
		if(acc == null) {
			throw new AccountNotFoundException("Account not found");
		}
		return new CustomerAccountDto(acc.getAccountId(), acc.getAccountType(), acc.getBalance());
	}
	
	@Transactional
	public Transaction deposit(TransactionAmount transactionAmount) {
		Account account = repo.getAccountByAccountId(transactionAmount.getAccountId());
		transactionAmountDto.setAccountId(transactionAmount.getAccountId());
		transactionAmountDto.setAmount(transactionAmount.getAmount());
		transactionAmountDto.setBalance(account.getBalance());
		Transaction transaction = rest.postForObject("http://localhost:8500/deposit", transactionAmountDto, Transaction.class);
		account.setBalance(transaction.getClosingBalance());
		if(repo.save(account) == null) {
			return null;
		}
		return transaction;
	}
	
	@Transactional
	public Transaction withdraw(TransactionAmount transactionAmount) {
		Account account = repo.getAccountByAccountId(transactionAmount.getAccountId());
		transactionAmountDto.setAccountId(transactionAmount.getAccountId());
		transactionAmountDto.setAmount(transactionAmount.getAmount());
		transactionAmountDto.setBalance(account.getBalance());
		Transaction transaction = rest.postForObject("http://localhost:8500/withdraw", transactionAmountDto, Transaction.class);
		account.setBalance(transaction.getClosingBalance());
		if(repo.save(account) == null) {
			return null;
		}
		return transaction;
	}
	
	@Transactional
	public List<Transaction> getAccountStatement(long accountId, String fromDate, String toDate) throws TransactionNotFoundException {
		if(repo.getAccountByAccountId(accountId) == null) 
			throw new TransactionNotFoundException("Transaction not found exception");
		@SuppressWarnings("unchecked")
		List<Transaction> transactionList = rest.getForObject("http://localhost:8500/getAccountStatement?accountId=" + accountId + "&fromDate=" + fromDate + "&toDate=" + toDate, List.class);
		return transactionList;
	}
	
	@Transactional
	public Transaction transfer(TransferAmount transferAmount) throws AccountNotFoundException {
		if(repo.getAccountByAccountId(transferAmount.getSourceAccountId()) == null ||
				repo.getAccountByAccountId(transferAmount.getTargetAccountId()) == null) 
			throw new AccountNotFoundException("Account not found");
		Account sourceAccount = repo.getAccountByAccountId(transferAmount.getSourceAccountId());
		Account targetAccount = repo.getAccountByAccountId(transferAmount.getTargetAccountId());
		transferAmountDto.setSourceAccountId(transferAmount.getSourceAccountId());
		transferAmountDto.setTargetAccountId(transferAmount.getTargetAccountId());
		transferAmountDto.setAmount(transferAmount.getAmount());
		transferAmountDto.setSourceClosingBalance(sourceAccount.getBalance());
		transferAmountDto.setTargetClosingBalance(targetAccount.getBalance());
		Transaction transaction = rest.postForObject("http://localhost:8500/transfer", transferAmountDto, Transaction.class);
		targetAccount.setBalance(transaction.getRecieverClosingBalance());
		repo.save(targetAccount);
		return transaction;
	}
}
