package com.lpatop.service;

import com.lpatop.model.Customer;

public interface CustomerService {

	
	public Customer save(Customer customer);

	public Customer getCustomerById(long id);
}
