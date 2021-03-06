package com.lpatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpatop.model.Address;
import com.lpatop.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	public Address save(@RequestBody Address address) {
		return addressService.save(address);

	}
	@GetMapping(value="/max")
	public double getMaxNumberPractice() {
		return addressService.getMaxNumber();
	}

}
