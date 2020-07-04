package com.alr.employeeproducer.integration.service;

import com.alr.employeeproducer.contracts.service.EmployeeService;
import com.alr.employeeproducer.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getEmployee_WithValidArgument_MustReturnEmployeeObj() throws Exception {
		Employee optEmp = employeeService.getEmployee(1);
		
		assertThat(employeeService).isNotNull();
		Assertions.assertTrue(optEmp.getName().contentEquals("emp1"));
	}
	
	@Test
	public void getEmployee_WithInvalidArgument_MustThrowException() {
		Assertions.assertThrows(Exception.class, () -> {
			employeeService.getEmployee(7);
		});
	}
}
