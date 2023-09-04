package com.storeManagment.manpowerplanning.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="manplanning")
public class ManPlanning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//(nullable=false,unique=false)
	private String sunday;
	//@Column(nullable=false,unique=false)
	private String monday;
	//@Column(nullable=false,unique=false)
	private String tuesday;
	//@Column(nullable=false,unique=false)
	private String wednesday;
	//@Column(nullable=false,unique=false)
	private String thursday;
	//@Column(nullable=false,unique=false)
	private String friday;
	//@Column(nullable=false,unique=false)
	private String saturday;
	//@Column(nullable=false,unique=false)
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String startDate;
	//@Column(nullable=false,unique=false)
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String endDate;
	//@Column(nullable=false,unique=false)
	private String store;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Employee emp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public ManPlanning(Long id, String sunday, String monday, String tuesday, String wednesday, String thursday,
			String friday, String saturday, String startDate, String endDate, String store, Employee emp) {
		super();
		this.id = id;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.startDate = startDate;
		this.endDate = endDate;
		this.store = store;
		this.emp = emp;
	}

	public ManPlanning() {
		super();
	}
}
