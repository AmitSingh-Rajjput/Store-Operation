package com.storeOperation.userregistration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,unique=true)
	private String storeName;
	@Column(nullable=false,unique=true)
	private String storeLocation;
	@OneToOne(mappedBy="store")
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public Store(Long id, String storeName, String storeLocation) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.storeLocation = storeLocation;
	}
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
