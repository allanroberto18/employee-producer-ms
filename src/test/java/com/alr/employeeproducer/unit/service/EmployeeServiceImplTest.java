package com.alr.employeeproducer.unit.service;

import com.alr.employeeproducer.contracts.repository.EmployeeRepository;
import com.alr.employeeproducer.model.Employee;
import com.alr.employeeproducer.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

  @Mock
  private EmployeeRepository employeeRepository;

  private EmployeeServiceImpl employeeService;

  @BeforeEach
  void setUp() {
    employeeService = new EmployeeServiceImpl(employeeRepository);
  }

  @Test
  public void findAll_MustReturnListOfEmployee() {
    Mockito.when(employeeRepository.findAll()).thenReturn(
        Arrays.asList(
            new Employee(1, "Emp1", "Designation1", 1000d),
            new Employee(2, "Emp2", "Designation2", 2000d)
        )
    );

    List<Employee> employees = employeeService.getAll();
    Assertions.assertEquals(2, employees.size());
  }

  @Test
  public void findById_WithValidArgument_MustReturnEmployee() throws Exception {
    Mockito.when(employeeRepository.findById(2)).thenReturn(Optional.of(new Employee(2, "Emp2", "Designation2", 2000d)));
    Employee employee = employeeService.getEmployee(2);
    Assertions.assertEquals(2, employee.getEmpId());
  }

  @Test
  public void findById_WithInvalidArgument_MustThrowException() {
    Assertions.assertThrows(Exception.class, () -> {
      Mockito.when(employeeRepository.findById(7)).thenReturn(Optional.empty());
      employeeService.getEmployee(7);
    });
  }
}
