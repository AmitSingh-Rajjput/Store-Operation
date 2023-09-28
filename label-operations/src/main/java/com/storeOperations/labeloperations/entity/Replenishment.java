package com.storeOperations.labeloperations.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="replenishment")
public class Replenishment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String itemCode;
	
	private Long currentQty;
	
	private Long maxQuantity;
	
	private Long qtyReplenished;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "self_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SelfLabel selfLabel;

	public Replenishment(Long id, String itemCode, Long currentQty, Long maxQuantity, Long qtyReplenished, String date,
			SelfLabel selfLabel) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.currentQty = currentQty;
		this.maxQuantity = maxQuantity;
		this.qtyReplenished = qtyReplenished;
		this.date = date;
		this.selfLabel = selfLabel;
	}

	public Replenishment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(Long currentQty) {
		this.currentQty = currentQty;
	}

	public Long getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Long maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Long getQtyReplenished() {
		return qtyReplenished;
	}

	public void setQtyReplenished(Long qtyReplenished) {
		this.qtyReplenished = qtyReplenished;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SelfLabel getSelfLabel() {
		return selfLabel;
	}

	public void setSelfLabel(SelfLabel selfLabel) {
		this.selfLabel = selfLabel;
	}

	public Replenishment(String itemCode, Long currentQty, Long maxQuantity, Long qtyReplenished, String date,
			SelfLabel selfLabel) {
		super();
		this.itemCode = itemCode;
		this.currentQty = currentQty;
		this.maxQuantity = maxQuantity;
		this.qtyReplenished = qtyReplenished;
		this.date = date;
		this.selfLabel = selfLabel;
	}
	
	

}
