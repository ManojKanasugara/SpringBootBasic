package com.lpatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpatop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
