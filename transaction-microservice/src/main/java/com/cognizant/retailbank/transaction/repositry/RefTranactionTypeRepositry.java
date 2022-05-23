package com.cognizant.retailbank.transaction.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.retailbank.transaction.model.RefTransactionTypes;

public interface RefTranactionTypeRepositry extends JpaRepository<RefTransactionTypes, String> {

}
