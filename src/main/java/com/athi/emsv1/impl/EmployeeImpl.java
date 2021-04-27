package com.athi.emsv1.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.emsv1.model.Employee;
import com.athi.emsv1.repository.EmployeeRepository;
import com.athi.emsv1.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String createEmployee(Employee employee) {
		String status = "Created!";
		try {
			if(employee != null)
				this.employeeRepository.save(employee);
			else
				status = "Failed!";
		} catch (Exception exception) {
			status = "Failed!";
			exception.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String status = "Updated!";
		try {
			if(employee != null)
				this.employeeRepository.save(employee);
			else
				status = "Failed!";
		} catch (Exception exception) {
			status = "Failed!";
			exception.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteEmployee(int id) {
		String status = "Deleted!";
		try {
			this.employeeRepository.deleteById(id);
		} catch (Exception exception) {
			status = "Failed!";
			exception.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = this.employeeRepository.findById(id);
		return employee.isPresent() ? employee.get() : null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

}
