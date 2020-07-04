package com.alr.employeeproducer.service;

import java.util.List;

import com.alr.employeeproducer.contracts.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alr.employeeproducer.model.Employee;
import com.alr.employeeproducer.contracts.repository.EmployeeRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee getEmployee(final Integer empId) throws Exception {
		return employeeRepository.findById(empId)
				.orElseThrow(Exception::new);
	}
	
	public Employee getDataFallBack(final Integer empId) throws Exception {
		return new Employee(empId, String.format("default emp with id: %d", empId), null, null);
	}
}
