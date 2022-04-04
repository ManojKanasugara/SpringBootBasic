package com.lpatop.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpatop.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@PersistenceContext
	EntityManager em;

	@GetMapping
	public List<Employee>  getMaxNumber() {
		Set<Employee> list = (Set<Employee>) em.createQuery("select emp from Employee emp").getResultList().stream().collect(Collectors.toSet());
		List<Employee> il=new ArrayList<>(list);
		
		 il.sort(Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo)));
		
       
    il.stream().forEach(x->{
    	System.out.println(x.getName());
    });
		return il;
	}

}
