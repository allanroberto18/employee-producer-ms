package com.alr.employeeproducer.contracts.repository;

import java.util.List;
import java.util.Optional;

import com.alr.employeeproducer.model.Employee;

public interface EmployeeRepository {
	List<Employee> findAll();
	Optional<Employee> findById(Integer id);
}
