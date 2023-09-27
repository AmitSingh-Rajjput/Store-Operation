package com.storeOperations.storeappointments.entity;

import java.util.List;



public class AppointentDto {
	
	private Appointment appointment;
	
	private List<Participants> participants;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}
	
	
	

}
