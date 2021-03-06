package com.springboot.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.entity.Employee;
import com.springboot.h2.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("")
	public ResponseEntity<Employee> create(@RequestBody Employee emp){
		return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.CREATED);
	}
	@GetMapping("")
	public ResponseEntity<List<Employee>> getAllEMployees(){
		return new ResponseEntity<>(employeeService.getAllEMployees(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long id){
		employeeService.deleteById(id);
		return new ResponseEntity<String>("Employee with id "+id+" deleted successfully",HttpStatus.OK);
	}
	@PutMapping("")
	public ResponseEntity<Employee> update(@RequestBody Employee emp){
		return new ResponseEntity<>(employeeService.updateEmployee(emp), HttpStatus.CREATED);
	}

}
