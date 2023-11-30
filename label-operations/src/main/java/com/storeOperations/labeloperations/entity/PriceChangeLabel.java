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

@Entity
public class PriceChangeLabel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
    private String date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "itemLabel_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ItemLabel itemLabel;

	public PriceChangeLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public ItemLabel getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(ItemLabel itemLabel) {
		this.itemLabel = itemLabel;
	}

	public PriceChangeLabel(Long id, String date, ItemLabel itemLabel) {
		super();
		this.id = id;
		this.date = date;
		this.itemLabel = itemLabel;
	}
	
	
	
	
	
	

}
