package com.lpatop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpatop.model.Laptop;
import com.lpatop.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	private final static Logger log = LoggerFactory.getLogger(LaptopController.class);
	private LaptopService laptopService;

	public LaptopController(LaptopService laptopService) {
		this.laptopService = laptopService;
	}

	@GetMapping(value = "/processor/{processor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Laptop> getLaptopByProcessor(@PathVariable String processor) {
		log.info("inside laptopController ");
		return laptopService.getLaptopByProcessor(processor);

	}

	@GetMapping(value = "processor/{processor}/ram/{ram}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Laptop> getLaptopByRam(@PathVariable String processor, @PathVariable String ram) {
		System.out.println(ram);
		return laptopService.getLaptopByProcessorAndRam(processor, Integer.parseInt(ram));

	}
}
