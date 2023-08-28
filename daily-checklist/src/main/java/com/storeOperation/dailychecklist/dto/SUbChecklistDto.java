package com.storeOperation.dailychecklist.dto;

public class SUbChecklistDto {
	
	private String subChecklistName;
	private String housekeepigChecklistType;
	public String getSubChecklistName() {
		return subChecklistName;
	}
	public void setSubChecklistName(String subChecklistName) {
		this.subChecklistName = subChecklistName;
	}
	public String getHousekeepigChecklistType() {
		return housekeepigChecklistType;
	}
	public void setHousekeepigChecklistType(String housekeepigChecklistType) {
		this.housekeepigChecklistType = housekeepigChecklistType;
	}
	public SUbChecklistDto(String subChecklistName, String housekeepigChecklistType) {
		super();
		this.subChecklistName = subChecklistName;
		this.housekeepigChecklistType = housekeepigChecklistType;
	}
	public SUbChecklistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
