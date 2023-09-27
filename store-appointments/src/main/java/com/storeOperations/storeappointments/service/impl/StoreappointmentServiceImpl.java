package com.storeOperations.storeappointments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperations.storeappointments.entity.AppointentDto;
import com.storeOperations.storeappointments.entity.Appointment;
import com.storeOperations.storeappointments.entity.Participants;
import com.storeOperations.storeappointments.exception.UserExceptionHandler;
import com.storeOperations.storeappointments.repository.AppointmentRepository;
import com.storeOperations.storeappointments.repository.ParticipantsRepository;
import com.storeOperations.storeappointments.service.StoreAppointementService;

@Service
public class StoreappointmentServiceImpl implements StoreAppointementService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private ParticipantsRepository participantRepo;

	@Override
	public String addAppointments(AppointentDto appdto) {
		Appointment appointmentNew = new Appointment();
		appointmentNew.setDescription(appdto.getAppointment().getDescription());
		appointmentNew.setDate(appdto.getAppointment().getDate());
		appointmentNew.setStartTime(appdto.getAppointment().getStartTime());
		appointmentNew.setEndTime(appdto.getAppointment().getEndTime());
		appointmentNew.setOrganiserName(appdto.getAppointment().getOrganiserName());
		appointmentNew.setOrganiserEmailId(appdto.getAppointment().getOrganiserEmailId());
		appointmentNew.setMeetingLink(appdto.getAppointment().getMeetingLink());
		appointmentNew.setStoreName(appdto.getAppointment().getStoreName());
		
		appointmentRepo.save(appointmentNew);
		
		for(int i=0;i< appdto.getParticipants().size();i++) {
			participantRepo.save(new Participants(appdto.getParticipants().get(i).getName(),appdto.getParticipants().get(i).getEmailId(), appointmentNew));
		}
		
		return "Add appointment sucessfully!!";
		
	}

	@Override
	public AppointentDto viewAppointment(Long id) {
		
		Appointment app = appointmentRepo.findById(id).get();
		if(app == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No appointment is found!");
		}
		List<Participants> listParticipation = participantRepo.findByAppointment(app);
		
		AppointentDto show = new AppointentDto();
		show.setAppointment(app);
		show.setParticipants(listParticipation);
		return show;
	}

	@Override
	public List<Appointment> showStoreAppointment(String storeName,String date) {
		
		List<Appointment> listStore = appointmentRepo.findByStoreNameAndDate(storeName,date);
		
		if(listStore.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No appointment is found!");
		}
		
		return listStore;
	}

}
