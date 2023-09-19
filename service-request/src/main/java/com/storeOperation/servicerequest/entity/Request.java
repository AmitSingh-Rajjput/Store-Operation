package com.storeOperation.servicerequest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Request_db")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String requestId;
	
	private String reqName;
	
	private String reqPhoneNo;
	
	private String reqEmail;
	
	private String reqAddress;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
	
	private String file;
	
	private String reqCategory;
	
	private String reqSubCategory;
	
	private String reqReason;
	
	private String reqDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public String getReqPhoneNo() {
		return reqPhoneNo;
	}

	public void setReqPhoneNo(String reqPhoneNo) {
		this.reqPhoneNo = reqPhoneNo;
	}

	public String getReqEmail() {
		return reqEmail;
	}

	public void setReqEmail(String reqEmail) {
		this.reqEmail = reqEmail;
	}

	public String getReqAddress() {
		return reqAddress;
	}

	public void setReqAddress(String reqAddress) {
		this.reqAddress = reqAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getReqCategory() {
		return reqCategory;
	}

	public void setReqCategory(String reqCategory) {
		this.reqCategory = reqCategory;
	}

	public String getReqSubCategory() {
		return reqSubCategory;
	}

	public void setReqSubCategory(String reqSubCategory) {
		this.reqSubCategory = reqSubCategory;
	}

	public String getReqReason() {
		return reqReason;
	}

	public void setReqReason(String reqReason) {
		this.reqReason = reqReason;
	}

	public String getReqDescription() {
		return reqDescription;
	}

	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}

	public Request(Long id, String requestId, String reqName, String reqPhoneNo, String reqEmail, String reqAddress,
			String date, String file, String reqCategory, String reqSubCategory, String reqReason,
			String reqDescription) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.reqName = reqName;
		this.reqPhoneNo = reqPhoneNo;
		this.reqEmail = reqEmail;
		this.reqAddress = reqAddress;
		this.date = date;
		this.file = file;
		this.reqCategory = reqCategory;
		this.reqSubCategory = reqSubCategory;
		this.reqReason = reqReason;
		this.reqDescription = reqDescription;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
