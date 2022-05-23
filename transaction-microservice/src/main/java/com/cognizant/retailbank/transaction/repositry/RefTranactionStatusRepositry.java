package com.cognizant.retailbank.transaction.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.retailbank.transaction.model.RefTransactionStatus;

public interface RefTranactionStatusRepositry extends JpaRepository<RefTransactionStatus, String> {

}
