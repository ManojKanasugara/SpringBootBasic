package com.lpatop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpatop.model.Address;
import com.lpatop.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepo;
	@PersistenceContext
	EntityManager em;

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}

	@Override
	public double getMaxNumber() {
		double a=0.0;
		// TODO Auto-generated method stub
	List<Object[]>	list= em.createNativeQuery("select id from ADDRESS").getResultList();
	try {
	 a= list.stream().
	mapToDouble(n->Integer.parseInt((String)n[0])).max().getAsDouble();
	System.out.println(a);
	}catch(Exception e) {
		System.out.println("ex handled");
	}
	return a;
	}

}
