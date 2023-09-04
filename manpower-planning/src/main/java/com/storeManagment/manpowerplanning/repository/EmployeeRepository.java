package com.storeManagment.manpowerplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeManagment.manpowerplanning.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByStoreName(String storeName);
	Employee findByUsername(String username);

}
