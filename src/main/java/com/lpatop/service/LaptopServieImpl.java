package com.lpatop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpatop.model.Laptop;
import com.lpatop.repository.LaptopRepo;

@Service
public class LaptopServieImpl implements LaptopService {
	private final LaptopRepo laptopRepo;

	public LaptopServieImpl(LaptopRepo laptopRepo) {
		this.laptopRepo = laptopRepo;
	}

	@Override
	public List<Laptop> getLaptopByProcessor(String processor) {
		// TODO Auto-generated method stub
		return laptopRepo.findByProcessor(processor);
	}
	@Override
	public List<Laptop> getLaptopByProcessorAndRam(String processor,int ram) {
		// TODO Auto-generated method stub
		return laptopRepo.findByProcessorAndRam(processor,ram);
	}

}
