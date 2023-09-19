package com.storeOperation.servicerequest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RequestCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String reqCategory;

	public RequestCategory(Long id, String reqCategory) {
		super();
		this.id = id;
		this.reqCategory = reqCategory;
	}

	public RequestCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqCategory() {
		return reqCategory;
	}

	public void setReqCategory(String reqCategory) {
		this.reqCategory = reqCategory;
		
	}

}
