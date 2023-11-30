package com.storeOperations.labeloperations.entity;

import java.util.List;

public class SearchLabelDto {
	private ItemLabel itemInfo;
	private SelfLabel shelfInfo;
	private List<ItemLabel> itemInfoList;
	public SearchLabelDto(ItemLabel itemInfo, SelfLabel shelfInfo, List<ItemLabel> itemInfoList) {
		super();
		this.itemInfo = itemInfo;
		this.shelfInfo = shelfInfo;
		this.itemInfoList = itemInfoList;
	}
	public SearchLabelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemLabel getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(ItemLabel itemInfo) {
		this.itemInfo = itemInfo;
	}
	public SelfLabel getShelfInfo() {
		return shelfInfo;
	}
	public void setShelfInfo(SelfLabel shelfInfo) {
		this.shelfInfo = shelfInfo;
	}
	public List<ItemLabel> getItemInfoList() {
		return itemInfoList;
	}
	public void setItemInfoList(List<ItemLabel> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}
	
	
	

}
