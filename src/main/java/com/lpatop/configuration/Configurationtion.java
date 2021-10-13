package com.lpatop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lpatop.service.CustomerServiceImpl;

@Configuration
public class Configurationtion{

	@Bean
	public CustomerServiceImpl getCustomerServiceImpl() {
		return new CustomerServiceImpl();

	}

}
