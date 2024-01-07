package com.storeOperation.productinfomation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderTable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String customerName;
	private String phoneNumber;
	private String orderStatus;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
	
	private String month;
	
	private String year;
	
	private String storeName;
	
	private String staffName;
	
	private Long registerId;
	
	private String paymentMode;
	
	private Float totalBill;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getStoreName() {
		return storeName;
	}



	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}



	public String getStaffName() {
		return staffName;
	}



	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}



	public Long getRegisterId() {
		return registerId;
	}



	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}



	public String getPaymentMode() {
		return paymentMode;
	}



	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}



	public Float getTotalBill() {
		return totalBill;
	}



	public void setTotalBill(Float totalBill) {
		this.totalBill = totalBill;
	}



	public OrderTable() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderTable(Long id, String customerName, String phoneNumber, String orderStatus, String date, String month,
			String year, String storeName, String staffName, Long registerId, String paymentMode, Float totalBill) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.orderStatus = orderStatus;
		this.date = date;
		this.month = month;
		this.year = year;
		this.storeName = storeName;
		this.staffName = staffName;
		this.registerId = registerId;
		this.paymentMode = paymentMode;
		this.totalBill = totalBill;
	}

}
