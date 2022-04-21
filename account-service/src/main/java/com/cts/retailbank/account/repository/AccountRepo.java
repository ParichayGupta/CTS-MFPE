package com.cts.retailbank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cts.retailbank.account.model.Account;

import java.util.List;

@Component
public interface AccountRepo extends JpaRepository<Account, Long> {

	public List<Account> getAccountByCustomerId(long custId);
	public Account getAccountByAccountId(long accId);
	
}
