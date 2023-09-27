package com.storeOperations.storeappointments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storeOperations.storeappointments.entity.AppointentDto;
import com.storeOperations.storeappointments.entity.Appointment;

public interface StoreAppointementService {
	
	String addAppointments(AppointentDto appdto );
	
	AppointentDto viewAppointment(Long id);
	
	List<Appointment> showStoreAppointment(String storeName,String date);

}
