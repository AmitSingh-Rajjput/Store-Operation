package com.storeOperations.labeloperations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="changeRequestLabel")
public class ChangeRequest {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	
	private String changeReqId;
	
	private String shelfId;
	
	private String storeName;
	
	private String changeDescription;
	
	private String changeImpact;
	
	private String priority;

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

	public String getChangeReqId() {
		return changeReqId;
	}

	public void setChangeReqId(String changeReqId) {
		this.changeReqId = changeReqId;
	}

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	public String getChangeImpact() {
		return changeImpact;
	}

	public void setChangeImpact(String changeImpact) {
		this.changeImpact = changeImpact;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public ChangeRequest(Long id, String date, String changeReqId, String shelfId, String changeDescription,
			String changeImpact, String priority) {
		super();
		this.id = id;
		this.date = date;
		this.changeReqId = changeReqId;
		this.shelfId = shelfId;
		this.changeDescription = changeDescription;
		this.changeImpact = changeImpact;
		this.priority = priority;
	}

	public ChangeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ChangeRequest(Long id, String date, String changeReqId, String shelfId, String storeName,
			String changeDescription, String changeImpact, String priority) {
		super();
		this.id = id;
		this.date = date;
		this.changeReqId = changeReqId;
		this.shelfId = shelfId;
		this.storeName = storeName;
		this.changeDescription = changeDescription;
		this.changeImpact = changeImpact;
		this.priority = priority;
	}
	
	
	
	

}
