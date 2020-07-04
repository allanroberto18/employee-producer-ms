package com.alr.employeeproducer.repository;

import com.alr.employeeproducer.contracts.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import com.alr.employeeproducer.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> findAll() {
		return Arrays.asList(new Employee(1, "emp1", "designation1", 1000d),
				new Employee(2, "emp2", "designation2", 2000d), new Employee(3, "emp3", "designation3", 3000d),
				new Employee(4, "emp4", "designation4", 4000d), new Employee(5, "emp5", "designation5", 5000d));
	}

	public Optional<Employee> findById(Integer id) {
		return Optional.ofNullable(convertToMap().get(id));
	}

	private Map<Integer, Employee> convertToMap() {
		return findAll().stream().collect(Collectors.toMap(Employee::getEmpId, emp -> emp));
	}
}
