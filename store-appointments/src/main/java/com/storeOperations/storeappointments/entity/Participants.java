package com.storeOperations.storeappointments.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="participants")
@Entity
public class Participants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	private String emailId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "app_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Appointment appointment;

	public Participants(Long id, String name, String emailId, Appointment appointment) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.appointment = appointment;
	}

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public Participants(String name, String emailId, Appointment appointment) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.appointment = appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
	

}
