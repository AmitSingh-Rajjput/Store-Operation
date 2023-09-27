package com.storeOperations.labeloperations.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="itemLabel")
public class ItemLabel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String itemLabelName;
	
	private String itemCode;
	
	private String itemLabelImg;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "self_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SelfLabel selfLabel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemLabelName() {
		return itemLabelName;
	}

	public void setItemLabelName(String itemLabelName) {
		this.itemLabelName = itemLabelName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemLabelImg() {
		return itemLabelImg;
	}

	public void setItemLabelImg(String itemLabelImg) {
		this.itemLabelImg = itemLabelImg;
	}

	public SelfLabel getSelfLabel() {
		return selfLabel;
	}

	public void setSelfLabel(SelfLabel selfLabel) {
		this.selfLabel = selfLabel;
	}

	public ItemLabel(Long id, String itemLabelName, String itemCode, String itemLabelImg, SelfLabel selfLabel) {
		super();
		this.id = id;
		this.itemLabelName = itemLabelName;
		this.itemCode = itemCode;
		this.itemLabelImg = itemLabelImg;
		this.selfLabel = selfLabel;
	}

	public ItemLabel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
