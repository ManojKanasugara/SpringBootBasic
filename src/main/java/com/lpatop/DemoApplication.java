package com.lpatop;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lpatop.model.Laptop;
import com.lpatop.model.StorageType;
import com.lpatop.repository.LaptopRepo;
import com.lpatop.repository.StorageTypeRepo;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	LaptopRepo laptopRepo;
	@Autowired
	StorageTypeRepo storageTypeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StorageType ssd512 = new StorageType("ssd", 512);
		StorageType hdd = new StorageType("hdd", 1024);
		StorageType ssd256 = new StorageType("ssd", 256);
		storageTypeRepo.save(ssd512);
		storageTypeRepo.save(hdd);
		storageTypeRepo.save(ssd256);
		
		Laptop dellI5 = new Laptop("Di5", "i5", 8);
		dellI5.getStorageType().add(ssd512);
		
		Laptop dellI7 = new Laptop("Di7", "i7", 16);
		dellI7.getStorageType().add(ssd256);
		
		Laptop dellI3 = new Laptop("Di3", "i3", 4);
		dellI3.getStorageType().add(hdd);		
		Laptop dellI5Hybrid = new Laptop("Di7", "i7", 16);
		dellI5Hybrid.getStorageType().add(ssd256);
		dellI5Hybrid.getStorageType().add(hdd);
		
		
		laptopRepo.save(dellI5);
		laptopRepo.save(dellI7);
		laptopRepo.save(dellI3);
		laptopRepo.save(dellI5Hybrid);
		

	}

}
