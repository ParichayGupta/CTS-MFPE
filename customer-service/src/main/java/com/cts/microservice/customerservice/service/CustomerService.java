package com.cts.microservice.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservice.customerservice.exception.CustomerNotFoundException;
import com.cts.microservice.customerservice.model.Account;
import com.cts.microservice.customerservice.model.AccountCreationStatus;
import com.cts.microservice.customerservice.model.Customer;
import com.cts.microservice.customerservice.repository.CustomerRepository;
import com.cts.microservice.customerservice.util.CustomerInput;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service

public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	Account account;
	

	
	
	 public AccountCreationStatus createCustomer(final CustomerInput customerinput) {
	     Customer cust = new Customer();
	     cust.setCustomerName(customerinput.getName());
	     cust.setAddress(customerinput.getAddress());
	     cust.setDob(customerinput.getDob());
	     cust.setPanNo(customerinput.getPan_no());
	     Customer result = repository.saveAndFlush(cust);
	     
	     account.setCustomerId(result.getCustomerId());
	     account.setAccountType(customerinput.getAccountType());
	     account.setAccHolderName(result.getCustomerName());
	     
	
	     AccountCreationStatus accountCreationStatus  = rest.postForObject("http://localhost:8081/account/create-account", account, AccountCreationStatus.class);
	    //52cd1657c969.ngrok.io
	     
	     return accountCreationStatus;
	        
	    }
	 
	    // Get all students from the h2 database.
//	    public List<Customer> getAll() {
//	        final List<Customer> customers = new ArrayList<>();
//	        repository.findAll().forEach(customer -> customers.add(customer));
//	        return customers;
//	    }
	
	 public Customer getCustomerDetails(int customerId) throws CustomerNotFoundException {
		 Customer cust = repository.getCustomerByCustomerId(customerId);
		 
		 if(cust == null) {
			 	System.out.println("anrhia  aifnwajn");
	    		throw new CustomerNotFoundException("Customer Doesn't Exist");
		 }
		 return cust;
	 }
	 
	 
	 
//	    public Customer getCustomer(int customerid) throws CustomerNotFoundException {
//	    	Customer customer = repository.findById(customerid).get();
//	    	log.info(" "+customer);
//	    	System.out.println(" "+customer);
//	    	if(customer == null )
//	    		throw new CustomerNotFoundException("Customer Doesn't Exist");
//	    	return customer;
//}
	    
	    }
