package com.storeOperations.storeappointments.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Appointment")
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	
	private String startTime;
	
	private String endTime;
	
	private String description;
	
	private String organiserName;
	
	private String organiserEmailId;
	
	private String meetingLink;
	
	private String storeName;

	public Appointment(Long id, String date, String startTime, String endTime, String description, String organiserName,
			String organiserEmailId, String meetingLink, String storeName) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.organiserName = organiserName;
		this.organiserEmailId = organiserEmailId;
		this.meetingLink = meetingLink;
		this.storeName = storeName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganiserName() {
		return organiserName;
	}

	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}

	public String getOrganiserEmailId() {
		return organiserEmailId;
	}

	public void setOrganiserEmailId(String organiserEmailId) {
		this.organiserEmailId = organiserEmailId;
	}

	public String getMeetingLink() {
		return meetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}

	public Appointment(Long id, String date, String startTime, String endTime, String description, String organiserName,
			String organiserEmailId, String meetingLink) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.organiserName = organiserName;
		this.organiserEmailId = organiserEmailId;
		this.meetingLink = meetingLink;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
