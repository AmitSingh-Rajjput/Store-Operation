package com.storeOperation.dailychecklist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Plumblingchecklist")
public class PlumblingChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String plumblingChecklistName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlumblingChecklistName() {
		return plumblingChecklistName;
	}
	public void setPlumblingChecklistName(String plumblingChecklistName) {
		this.plumblingChecklistName = plumblingChecklistName;
	}
	public PlumblingChecklist(Long id, String plumblingChecklistName) {
		super();
		this.id = id;
		this.plumblingChecklistName = plumblingChecklistName;
	}
	public PlumblingChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
