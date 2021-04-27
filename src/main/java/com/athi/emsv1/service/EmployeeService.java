package com.athi.emsv1.service;

import java.util.List;

import com.athi.emsv1.model.Employee;

public interface EmployeeService {

	public String createEmployee(Employee employee);

	public String updateEmployee(Employee employee);

	public String deleteEmployee(int id);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

}
