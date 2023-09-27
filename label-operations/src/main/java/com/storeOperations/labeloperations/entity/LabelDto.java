package com.storeOperations.labeloperations.entity;

import java.util.List;

public class LabelDto {
	
	private SelfLabel selfLabel;
	
	private List<ItemLabel> itemList;

	public SelfLabel getSelfLabel() {
		return selfLabel;
	}

	public void setSelfLabel(SelfLabel selfLabel) {
		this.selfLabel = selfLabel;
	}

	public List<ItemLabel> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemLabel> itemList) {
		this.itemList = itemList;
	}

	public LabelDto(SelfLabel selfLabel, List<ItemLabel> itemList) {
		super();
		this.selfLabel = selfLabel;
		this.itemList = itemList;
	}

	public LabelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
