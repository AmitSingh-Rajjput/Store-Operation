package com.storeOperations.labeloperations.entity;

import java.util.List;

public class ReplenishmentDto {
	
	private String selfLabel;
	
	private String storeName;
	
	private List<Replenishment> listItem;

	public String getSelfLabel() {
		return selfLabel;
	}

	public void setSelfLabel(String selfLabel) {
		this.selfLabel = selfLabel;
	}

	public List<Replenishment> getListItem() {
		return listItem;
	}

	public void setListItem(List<Replenishment> listItem) {
		this.listItem = listItem;
	}

	public ReplenishmentDto(String selfLabel, List<Replenishment> listItem) {
		super();
		this.selfLabel = selfLabel;
		this.listItem = listItem;
	}

	public ReplenishmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ReplenishmentDto(String selfLabel, String storeName, List<Replenishment> listItem) {
		super();
		this.selfLabel = selfLabel;
		this.storeName = storeName;
		this.listItem = listItem;
	}
	
	
	

}
