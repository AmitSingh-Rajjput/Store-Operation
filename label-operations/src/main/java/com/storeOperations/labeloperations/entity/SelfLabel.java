package com.storeOperations.labeloperations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="selfLabel")
public class SelfLabel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String selfLabelName;
	
	private String selfLabelId;
	
	private String selfLabelImg;
	
	private String storeName;
	
	private Long maxItem;
	
	private Long maxQtyForSingleProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSelfLabelName() {
		return selfLabelName;
	}

	public void setSelfLabelName(String selfLabelName) {
		this.selfLabelName = selfLabelName;
	}

	public String getSelfLabelId() {
		return selfLabelId;
	}

	public void setSelfLabelId(String selfLabelId) {
		this.selfLabelId = selfLabelId;
	}

	public String getSelfLabelImg() {
		return selfLabelImg;
	}

	public void setSelfLabelImg(String selfLabelImg) {
		this.selfLabelImg = selfLabelImg;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(Long maxItem) {
		this.maxItem = maxItem;
	}

	public SelfLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelfLabel(Long id, String selfLabelName, String selfLabelId, String selfLabelImg, String storeName,
			Long maxItem) {
		super();
		this.id = id;
		this.selfLabelName = selfLabelName;
		this.selfLabelId = selfLabelId;
		this.selfLabelImg = selfLabelImg;
		this.storeName = storeName;
		this.maxItem = maxItem;
	}

	public SelfLabel(Long id, String selfLabelName, String selfLabelId, String selfLabelImg, String storeName,
			Long maxItem, Long maxQtyForSingleProduct) {
		super();
		this.id = id;
		this.selfLabelName = selfLabelName;
		this.selfLabelId = selfLabelId;
		this.selfLabelImg = selfLabelImg;
		this.storeName = storeName;
		this.maxItem = maxItem;
		this.maxQtyForSingleProduct = maxQtyForSingleProduct;
	}

	public Long getMaxQtyForSingleProduct() {
		return maxQtyForSingleProduct;
	}

	public void setMaxQtyForSingleProduct(Long maxQtyForSingleProduct) {
		this.maxQtyForSingleProduct = maxQtyForSingleProduct;
	}
	
	
	

}
