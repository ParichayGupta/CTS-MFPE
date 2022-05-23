package com.cognizant.retailbank.transaction.repositry;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.cognizant.retailbank.transaction.model.FinancialTransactions;

public interface TransactionRepositry extends JpaRepository<FinancialTransactions, Long> {
	
	public List<FinancialTransactions> findAllByAccountIdIn(List<String> accounts,Sort sort);
	
	@Query(value = "select * from financial_transactions where date_of_transaction BETWEEN :startDate AND :endDate",nativeQuery = true)
	public List<FinancialTransactions> findAllByDateOfTransactionBetween(@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	@Query(value = "select * from financial_transactions where MONTH(date_of_transaction) = MONTH(CURRENT_DATE())",nativeQuery = true)
	public List<FinancialTransactions> findAllByMonth();
	
}
