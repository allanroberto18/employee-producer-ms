package com.alr.employeeproducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Integer empId;
	private String name;
	private String designation;
	private Double salary;
}
