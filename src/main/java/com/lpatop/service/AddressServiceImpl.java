package com.lpatop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpatop.model.Address;
import com.lpatop.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}

}
