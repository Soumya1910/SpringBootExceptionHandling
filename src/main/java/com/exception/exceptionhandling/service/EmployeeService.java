package com.exception.exceptionhandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exception.exceptionhandling.entity.EmployeeDetails;
import com.exception.exceptionhandling.exception.ResourceNotFoundException;
import com.exception.exceptionhandling.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	public List<EmployeeDetails> findAllEmployees() {
		return empRepo.findAll();
	}

	public EmployeeDetails findEmployeeById(Long empId) {
		return empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not present : "+empId));
	}

}
