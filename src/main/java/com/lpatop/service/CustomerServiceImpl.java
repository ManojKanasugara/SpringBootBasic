package com.lpatop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpatop.model.Customer;
import com.lpatop.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id).get();
	}

}
