package com.alr.employeeproducer.contracts.service;

import com.alr.employeeproducer.model.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> getAll();
  Employee getEmployee(final Integer empId) throws Exception;
}
