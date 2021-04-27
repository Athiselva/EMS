package com.athi.emsv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athi.emsv1.model.Employee;
import com.athi.emsv1.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public String createEmployee(@RequestBody String payload) throws JsonMappingException, JsonProcessingException {
		Employee employee = null;
		if (payload != null && !payload.isEmpty())
			employee = new ObjectMapper().readValue(payload, Employee.class);
		return this.employeeService.createEmployee(employee);
	}

	@PutMapping("/update")
	public String updateEmployee(@RequestBody String payload) throws JsonMappingException, JsonProcessingException {
		Employee employee = null;
		if (payload != null && !payload.isEmpty())
			employee = new ObjectMapper().readValue(payload, Employee.class);
		return this.employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return this.employeeService.deleteEmployee(id);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(this.employeeService.getAllEmployees(), HttpStatus.OK);
	}

}
