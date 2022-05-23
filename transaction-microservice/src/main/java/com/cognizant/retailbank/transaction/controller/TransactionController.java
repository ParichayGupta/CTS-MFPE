package com.cognizant.retailbank.transaction.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.retailbank.transaction.dto.TransactionStatusDTO;
import com.cognizant.retailbank.transaction.model.FinancialTransactions;
import com.cognizant.retailbank.transaction.model.RefTransactionStatus;
import com.cognizant.retailbank.transaction.repositry.TransactionRepositry;
import com.cognizant.retailbank.transaction.service.TransactionService;
import com.cognizant.retailbank.transaction.utils.DepositInput;
import com.cognizant.retailbank.transaction.utils.TransferInput;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/test")
	public String testService() {
		return "Test";
	}
	
	@PostMapping("/deposit")
	public TransactionStatusDTO depositAmount(@RequestBody DepositInput input) { 
		return transactionService.deposit(String.valueOf(input.getAccountId()),input.getAmount(),input.getBalance());
	}
	
	@PostMapping("/withdraw")
	public TransactionStatusDTO withdrawAmount(@RequestBody DepositInput input) { 
		return transactionService.withdraw(String.valueOf(input.getAccountId()),input.getAmount(),input.getBalance());
	}
	
	@PostMapping("/transfer")
	public TransactionStatusDTO transferAmount(@RequestBody TransferInput input) {
		return transactionService.transfer(String.valueOf(input.getSourceAccountId()), String.valueOf(input.getTargetAccountId()), input.getAmount(),input.getSourceClosingBalance(),input.getTargetClosingBalance());
	}
	
	@GetMapping("/getTransactions")
	public List<FinancialTransactions> getAllTransactions(){
		return transactionService.getAllTransactions("abcd");
	}
	
	@GetMapping("/getAccountStatement")
	public List<TransactionStatusDTO> getAccountTransaction(@RequestParam String accountId,
			String fromDate,String toDate
			){
		log.info("from Val {}",fromDate.length());
		log.info("from Val "+fromDate.length());
		return transactionService.getAccountStatement(accountId, fromDate, toDate); 
	}
}
