package com.storeOperation.userregistration.entity;


public class RegisterDto {
	
	private String name;
	private String username;
	private String location;
	private String address;
	private String email;
	private String phoneNumber;
	private String gender;
	private String password;
	private String storeRef;
	public String getstoreRef() {
		return storeRef;
	}
	public void setstoreRef(String storeRef) {
		this.storeRef = storeRef;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegisterDto(String name, String username, String location, String address, String email, String phoneNumber,
			String gender, String password,String storeRef) {
		super();
		this.name = name;
		this.username = username;
		this.location = location;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.password = password;
		this.storeRef = storeRef;
	}
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
