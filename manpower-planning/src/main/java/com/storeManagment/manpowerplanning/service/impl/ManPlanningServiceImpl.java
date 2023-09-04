package com.storeManagment.manpowerplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeManagment.manpowerplanning.entity.Employee;
import com.storeManagment.manpowerplanning.entity.ManPlanning;
import com.storeManagment.manpowerplanning.exception.UserExceptionHandler;
import com.storeManagment.manpowerplanning.repository.EmployeeRepository;
import com.storeManagment.manpowerplanning.repository.ManPlanningRepository;
import com.storeManagment.manpowerplanning.service.ManPlanningService;


@Service
public class ManPlanningServiceImpl implements ManPlanningService  {
	
	@Autowired
	private ManPlanningRepository manPlanningRepo;
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public ManPlanning addManPlanningShedule(ManPlanning manPlanning,Long empId) {
		Employee emp = empRepo.findById(empId).get();
		if(emp == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Employee is not found!!");
		}
		
//		Employee empStore = empRepo.findByStoreName(emp.getStoreName());
//		if(empStore.getStoreName() == manPlanning.getStore()) {
//			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store is not same!!");
//		}
		
		ManPlanning manPlan = new ManPlanning();
		manPlan.setSunday(manPlanning.getSunday());
		manPlan.setMonday(manPlanning.getMonday());
		manPlan.setTuesday(manPlanning.getTuesday());
		manPlan.setWednesday(manPlanning.getWednesday());
		manPlan.setThursday(manPlanning.getThursday());
		manPlan.setFriday(manPlanning.getFriday());
		manPlan.setSaturday(manPlanning.getSaturday());
		manPlan.setEmp(emp);
		manPlan.setEndDate(manPlanning.getEndDate());
		manPlan.setStartDate(manPlanning.getStartDate());
		manPlan.setStore(manPlanning.getStore());

		return manPlanningRepo.save(manPlan);
		
	}

	@Override
	public List<ManPlanning> showTimeTable(String startDate,String store) {
		List<ManPlanning> schedule = manPlanningRepo.findByStartDateAndStore(startDate,store);
		if(schedule.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "StartDate is not found!!");
		}
		return schedule;
	}

}
