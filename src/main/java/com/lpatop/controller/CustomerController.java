package com.lpatop.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpatop.dto.CustomerDto;
import com.lpatop.model.Customer;
import com.lpatop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	// constructor injection
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
		log.info("enterted CustomerController save method");
		return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
	}

	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable long id) {
		log.info(log.getName() + " enterted CustomerController getCustomerById method ");
		return customerService.getCustomerById(id);

	}

	@GetMapping(value = "/object/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDto getCustomByIdUsingObject(@PathVariable long id) {
		log.info(log.getName());
		return customerService.getCustomFieldsUsingObject(id);

	}

	@GetMapping(value = "/transformers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDto getCustomerfromTransformersAliasToBeanById(@PathVariable long id) {
		log.info(log.getName());
		return customerService.getCustomFieldsFromTransformersAliasToBean(id);

	}
}
