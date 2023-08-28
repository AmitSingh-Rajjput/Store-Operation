package com.storeOperation.dailychecklist.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="houseChecklist")
public class HousekeepingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String checkListType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCheckListType() {
		return checkListType;
	}
	public void setCheckListType(String checkListType) {
		this.checkListType = checkListType;
	}
	public HousekeepingChecklist(Long id, String checkListType) {
		super();
		this.id = id;
		this.checkListType = checkListType;
	}
	public HousekeepingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
