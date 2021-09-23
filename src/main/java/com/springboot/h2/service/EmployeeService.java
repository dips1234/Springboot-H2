package com.springboot.h2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.entity.Employee;
import com.springboot.h2.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee createEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	public List<Employee> getAllEMployees(){
		return employeeRepo.findAll();
	}
	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).orElse(new Employee());
	}
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}
	public Employee updateEmployee(Employee emp) {
		 employeeRepo.deleteById(emp.getId());
		return  employeeRepo.save(emp);
	}

}
