package com.storeOperations.storeappointments.controller;

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

import com.storeOperations.storeappointments.entity.AppointentDto;
import com.storeOperations.storeappointments.entity.Appointment;
import com.storeOperations.storeappointments.service.StoreAppointementService;

@RestController
@RequestMapping("/api/appointment")
public class StoreAppointmentController {
	
	@Autowired
	private StoreAppointementService storeAppointment;
	

	@PostMapping("/addAppointment")
	public ResponseEntity<String> createAppointment(@RequestBody AppointentDto appointmnetDto){
		String savedapp = storeAppointment.addAppointments(appointmnetDto);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showAppointment/{id}")
	public ResponseEntity<AppointentDto> showAppointment(@PathVariable("id") Long id){
		AppointentDto savedapp = storeAppointment.viewAppointment(id);
		return new ResponseEntity<>(savedapp,HttpStatus.OK);
	}
	
	@GetMapping("/showAppointmentStore/{storeName}/{date}")
	public ResponseEntity<List<Appointment>> showAppointmentStore(@PathVariable("storeName") String storeName,@PathVariable("date") String date){
		List<Appointment> savedapp = storeAppointment.showStoreAppointment(storeName,date);
		return new ResponseEntity<>(savedapp,HttpStatus.OK);
	}

}
