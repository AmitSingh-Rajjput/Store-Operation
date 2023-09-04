package com.storeManagment.manpowerplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeManagment.manpowerplanning.entity.Employee;
import com.storeManagment.manpowerplanning.entity.ManPlanning;
import com.storeManagment.manpowerplanning.service.EmployeeService;
import com.storeManagment.manpowerplanning.service.ManPlanningService;

@RestController
@RequestMapping("/api/manplanning")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ManPlanningService manPlannigService;
	

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee empAdd = empService.addEmployee(emp);
		return new ResponseEntity<>(empAdd,HttpStatus.CREATED);
	}
	
	@PostMapping("/addEmployeeTimeTable/{empId}")
	public ResponseEntity<ManPlanning> addManPlanningSchedule(@RequestBody ManPlanning emp,@PathVariable("empId") Long empId){
		ManPlanning manplan = manPlannigService.addManPlanningShedule(emp,empId);
		return new ResponseEntity<>(manplan,HttpStatus.CREATED);
	}
	
	@GetMapping("/showTimeTable/{startDate}/{store}")
	public ResponseEntity<List<ManPlanning>> showSchedule(@PathVariable("startDate") String startDate,@PathVariable("store") String store){
		List<ManPlanning> manplan = manPlannigService.showTimeTable(startDate,store);
		return new ResponseEntity<>(manplan,HttpStatus.OK);
	}
	
	@GetMapping("/showUserDetails/{username}")
	public ResponseEntity<Employee> showUserDetails(@PathVariable("username") String username){
		Employee emp = empService.userDetails(username);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	
	
	

}
