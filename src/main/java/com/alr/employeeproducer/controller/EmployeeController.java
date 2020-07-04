package com.alr.employeeproducer.controller;

import com.alr.employeeproducer.contracts.service.EmployeeService;
import com.alr.employeeproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/producer")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/employee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer empId) throws Exception {
		return ResponseEntity.ok().body(employeeService.getEmployee(empId));
	}

	@GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.getAll());
	}
}
