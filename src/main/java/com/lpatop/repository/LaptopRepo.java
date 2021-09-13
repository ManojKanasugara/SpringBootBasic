package com.lpatop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lpatop.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {

	List<Laptop> findByProcessor(String processor);

	@Query("Select l from Laptop l where l.processor=?1 and l.ram= ?2 ")
	List<Laptop> findByProcessorAndRam(String processor,int ram);

}
