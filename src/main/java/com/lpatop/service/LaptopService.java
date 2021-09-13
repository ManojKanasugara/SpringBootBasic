package com.lpatop.service;

import java.util.List;


import com.lpatop.model.Laptop;

public interface LaptopService {

	List<Laptop> getLaptopByProcessor(String processor);

	List<Laptop> getLaptopByProcessorAndRam(String processor,int ram);

	

}
