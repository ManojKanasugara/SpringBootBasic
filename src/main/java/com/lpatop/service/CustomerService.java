package com.lpatop.service;

import com.lpatop.dto.CustomerDto;
import com.lpatop.model.Customer;

public interface CustomerService {

	public Customer save(Customer customer);

	public Customer getCustomerById(long id);

	public CustomerDto getCustomFieldsUsingObject(long id);

	public CustomerDto getCustomFieldsFromTransformersAliasToBean(long id);
}
