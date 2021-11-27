package com.exception.exceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.exceptionhandling.entity.EmployeeDetails;
import com.exception.exceptionhandling.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	// get all employees
	@GetMapping()
	public List<EmployeeDetails> getAllEmployees(){
		
		return empService.findAllEmployees();
		
	}
	
	// get employee based on id
	@GetMapping("/{empId}")
	public EmployeeDetails getEmployeeById(@PathVariable("empId") Long empId) {
		return this.empService.findEmployeeById(empId);
	}

}
