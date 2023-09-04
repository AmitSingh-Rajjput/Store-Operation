package com.storeManagment.manpowerplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeManagment.manpowerplanning.entity.Employee;
import com.storeManagment.manpowerplanning.exception.UserExceptionHandler;
import com.storeManagment.manpowerplanning.repository.EmployeeRepository;
import com.storeManagment.manpowerplanning.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		Employee saved = empRepo.save(emp);
		return saved;
		
	}

	@Override
	public Employee userDetails(String username) {
		Employee user = empRepo.findByUsername(username);
		if(user == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "User is not found!!");
		}
		return user;
	}
	

}
