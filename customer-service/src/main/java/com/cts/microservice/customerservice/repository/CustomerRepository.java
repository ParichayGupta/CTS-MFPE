package com.cts.microservice.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.microservice.customerservice.model.Customer;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer getCustomerByCustomerId(int customerId);
	
}
