package com.lpatop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpatop.model.Address;
import com.lpatop.model.Customer;
import com.lpatop.repository.AddressRepository;
import com.lpatop.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Customer save(Customer customer) {

		Customer customerEntity = customer;
		customerEntity.getAddressList().addAll(customer.getAddressList());
		customerRepo.save(customerEntity);
		for (Address addressObj : customer.getAddressList()) {
			addressObj.setCustomer(customer);
			addressRepo.save(addressObj);
		}

		return customerEntity;
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id).get();
	}

}
