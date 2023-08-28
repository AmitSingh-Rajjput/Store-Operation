package com.storeOperation.dailychecklist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TaskPlumbling")
public class TaskPlumblingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	private String checklist;
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
	public String getChecklist() {
		return checklist;
	}
	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TaskPlumblingChecklist(Long id, String date, String checklist, String storeName, String status) {
		super();
		this.id = id;
		this.date = date;
		this.checklist = checklist;
		this.storeName = storeName;
		this.status = status;
	}
	public TaskPlumblingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
