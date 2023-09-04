package com.storeManagment.manpowerplanning.service;

import com.storeManagment.manpowerplanning.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	Employee userDetails(String username);


}
