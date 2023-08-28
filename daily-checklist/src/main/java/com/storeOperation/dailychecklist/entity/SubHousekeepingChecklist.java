package com.storeOperation.dailychecklist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="subHousekeepingChecklist")
public class SubHousekeepingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subChecklistName;
	private String housekeepingChecklistType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubChecklistName() {
		return subChecklistName;
	}

	public void setSubChecklistName(String subChecklistName) {
		this.subChecklistName = subChecklistName;
	}

	
	public SubHousekeepingChecklist(Long id, String subChecklistName, String housekeepingChecklistType) {
		super();
		this.id = id;
		this.subChecklistName = subChecklistName;
		this.housekeepingChecklistType = housekeepingChecklistType;
	}

	public String getHousekeepingChecklistType() {
		return housekeepingChecklistType;
	}

	public void setHousekeepingChecklistType(String housekeepingChecklistType) {
		this.housekeepingChecklistType = housekeepingChecklistType;
	}

	public SubHousekeepingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
