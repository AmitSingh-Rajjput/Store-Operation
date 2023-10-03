package com.storeOperation.bankdeposits.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bankDepositsDetails")
public class BankDepositsDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;
	
	private String handOverDocumentNumber;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bankdeposit_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BankDeposits bankDeposit;

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

	public String getHandOverDocumentNumber() {
		return handOverDocumentNumber;
	}

	public void setHandOverDocumentNumber(String handOverDocumentNumber) {
		this.handOverDocumentNumber = handOverDocumentNumber;
	}

	public BankDeposits getBankDeposit() {
		return bankDeposit;
	}

	public void setBankDeposit(BankDeposits bankDeposit) {
		this.bankDeposit = bankDeposit;
	}

	public BankDepositsDetails(Long id, String date, String handOverDocumentNumber, BankDeposits bankDeposit) {
		super();
		this.id = id;
		this.date = date;
		this.handOverDocumentNumber = handOverDocumentNumber;
		this.bankDeposit = bankDeposit;
	}

	public BankDepositsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDepositsDetails(String date, String handOverDocumentNumber, BankDeposits bankDeposit) {
		super();
		this.date = date;
		this.handOverDocumentNumber = handOverDocumentNumber;
		this.bankDeposit = bankDeposit;
	}
	
	

}
