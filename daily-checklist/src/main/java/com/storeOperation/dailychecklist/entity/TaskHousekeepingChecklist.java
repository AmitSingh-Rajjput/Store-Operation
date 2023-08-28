package com.storeOperation.dailychecklist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TaskHouseKeeping")
public class TaskHousekeepingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	private String checkListId;
	private String subChecklistId;
	private String storeName;
	private String status;
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
	public String getCheckListId() {
		return checkListId;
	}
	public void setCheckListId(String checkListId) {
		this.checkListId = checkListId;
	}
	public String getSubChecklistId() {
		return subChecklistId;
	}
	public void setSubChecklistId(String subChecklistId) {
		this.subChecklistId = subChecklistId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public TaskHousekeepingChecklist(Long id, String date, String checkListId, String subChecklistId, String storeName,
			String status) {
		super();
		this.id = id;
		this.date = date;
		this.checkListId = checkListId;
		this.subChecklistId = subChecklistId;
		this.storeName = storeName;
		this.status = status;
	}
	public TaskHousekeepingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
