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
import jakarta.persistence.OneToOne;

@Entity
public class RequestUpdateAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String updatestatusdate;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "req_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Request request;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatestatusdate() {
		return updatestatusdate;
	}

	public void setUpdatestatusdate(String updatestatusdate) {
		this.updatestatusdate = updatestatusdate;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public RequestUpdateAction(Long id, String status, String updatestatusdate, Request request) {
		super();
		this.id = id;
		this.status = status;
		this.updatestatusdate = updatestatusdate;
		this.request = request;
	}

	public RequestUpdateAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
