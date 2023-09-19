package com.storeOperation.servicerequest.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RequestDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String updatedate;
	
	private String action;
	
	private String technicalNotes;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "req_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Request request;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTechnicalNotes() {
		return technicalNotes;
	}

	public void setTechnicalNotes(String technicalNotes) {
		this.technicalNotes = technicalNotes;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public RequestDetails(Long id, String updatedate, String action, String technicalNotes, Request request) {
		super();
		this.id = id;
		this.updatedate = updatedate;
		this.action = action;
		this.technicalNotes = technicalNotes;
		this.request = request;
	}

	public RequestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
