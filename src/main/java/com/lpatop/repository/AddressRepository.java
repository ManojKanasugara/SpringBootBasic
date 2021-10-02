package com.lpatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpatop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
