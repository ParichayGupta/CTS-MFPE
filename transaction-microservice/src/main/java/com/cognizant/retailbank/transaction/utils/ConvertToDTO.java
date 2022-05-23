package com.cognizant.retailbank.transaction.utils;

import org.springframework.web.client.RestTemplate;

import com.cognizant.retailbank.transaction.dto.TransactionStatusDTO;
import com.cognizant.retailbank.transaction.model.FinancialTransactions;

public class ConvertToDTO {

	public static TransactionStatusDTO convertToTransactionDTO(FinancialTransactions financialTransactions,boolean status,float recieverAccountBalance) {
		TransactionStatusDTO transactionStatusDTO=new TransactionStatusDTO();
		transactionStatusDTO.setSuccess(status);
		transactionStatusDTO.setSenderAccountId(financialTransactions.getAccountId());
		transactionStatusDTO.setRecieverAccountId(financialTransactions.getOtherPartyAccountId());
		transactionStatusDTO.setTransactionAmount(financialTransactions.getAmountOfTransaction());
		transactionStatusDTO.setTransactionDate(financialTransactions.getDateOfTransaction());
		transactionStatusDTO.setTransactionId(financialTransactions.getTransactionId());
		transactionStatusDTO.setTransactionStatusCode(financialTransactions.getRefTransactionStatus().getTransactionStatusCode());
		transactionStatusDTO.setTransactionTypeCode(financialTransactions.getRefTransactionTypes().getTransactionTypeCode());
		transactionStatusDTO.setTransactionStatusDescription(financialTransactions.getRefTransactionStatus().getTransactionStatusDescription());
		transactionStatusDTO.setTransactionTypeDescription(financialTransactions.getRefTransactionTypes().getTransactionTypeDescription());
		transactionStatusDTO.setClosingBalance(financialTransactions.getClosingBalance());
		if(financialTransactions.getRefTransactionTypes().getTransactionTypeCode().equalsIgnoreCase("TRANSFER") && financialTransactions.getRefTransactionStatus().getTransactionStatusCode().equalsIgnoreCase("SUCCESS")) {
			transactionStatusDTO.setRecieverClosingBalance(recieverAccountBalance);
		}
		return transactionStatusDTO;
	}
}
