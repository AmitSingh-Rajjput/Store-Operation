package com.storeManagment.manpowerplanning.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,unique=false)
	private String name;
	@Column(nullable=false,unique=true)
	private String username;
	@Column(nullable=false,unique=false)
	private String storeName;
	@Column(nullable=false,unique=true)
	private String phoneNo;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false,unique=false)
	private String designation;
	private String address;
	@Column(nullable=false,unique=false)
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String dob;
	@Column(nullable=false,unique=false)
	private String gender;
	public Employee(Long id, String name, String username, String storeName, String phoneNo, String email,
			String designation, String address, String dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.storeName = storeName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.designation = designation;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
