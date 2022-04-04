package com.lpatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpatop.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
