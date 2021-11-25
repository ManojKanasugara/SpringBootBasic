package com.lpatop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.lpatop.dto.CustomerDto;
import com.lpatop.exception.CustomerNotFoundException;
import com.lpatop.model.Address;
import com.lpatop.model.Customer;
import com.lpatop.repository.AddressRepository;
import com.lpatop.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@PersistenceContext
	EntityManager em;
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
		return customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(" customer not found with id " + id));
	}

	@Override
	public CustomerDto getCustomFieldsUsingObject(long id) {
		CustomerDto cust = new CustomerDto();
		int phone = 0;
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNativeQuery(
				"select first_name as firstName , email,phone_number as phoneNumber " + "from customer where id= ?1")
				.setParameter(1, id).getResultList();
		for (Object[] l : list) {
			cust.setFIRSTNAME(l[0].toString());
			cust.setEMAIL(l[1].toString());
			cust.setPhoneNumber(l[2].toString());

		}
		return cust;
	}

	@Override
	public CustomerDto getCustomFieldsFromTransformersAliasToBean(long id) {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<CustomerDto> list = em
				.createNativeQuery("select first_name as firstName , email,phone_number as phoneNumber "
						+ "from customer where id= ?1")
				.setParameter(1, id).unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(CustomerDto.class)).getResultList();
		return list.get(0);

	}

}
