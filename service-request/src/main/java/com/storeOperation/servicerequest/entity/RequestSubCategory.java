package com.storeOperation.servicerequest.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RequestSubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String subCategorty;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private RequestCategory reqCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubCategorty() {
		return subCategorty;
	}

	public void setSubCategorty(String subCategorty) {
		this.subCategorty = subCategorty;
	}

	public RequestCategory getReqCategory() {
		return reqCategory;
	}

	public void setReqCategory(RequestCategory reqCategory) {
		this.reqCategory = reqCategory;
	}

	public RequestSubCategory(Long id, String subCategorty, RequestCategory reqCategory) {
		super();
		this.id = id;
		this.subCategorty = subCategorty;
		this.reqCategory = reqCategory;
	}

	public RequestSubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
