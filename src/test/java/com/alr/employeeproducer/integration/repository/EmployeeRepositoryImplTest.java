package com.alr.employeeproducer.integration.repository;

import java.util.List;
import java.util.Optional;

import com.alr.employeeproducer.contracts.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alr.employeeproducer.model.Employee;

@SpringBootTest
public class EmployeeRepositoryImplTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void findAll_MustReturnListOfEmployee() {
		List<Employee> list = employeeRepository.findAll();
		
		Assertions.assertTrue(list.size() == 5);
	}
	
	@Test
	public void findById_WithValidArgument_MustReturnOptionalEmployee() {
		Optional<Employee> optEmployee = employeeRepository.findById(1);
		
		Assertions.assertEquals(1, optEmployee.get().getEmpId());
	}
	
	@Test
	public void findById_WithInvalidArgument_MustReturnOptionalEmployee() {
		Optional<Employee> optEmployee = employeeRepository.findById(7);
		
		Assertions.assertTrue(optEmployee.isEmpty());
	}
}
