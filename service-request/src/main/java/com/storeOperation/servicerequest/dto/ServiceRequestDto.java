package com.storeOperation.servicerequest.dto;

import java.util.List;

import com.storeOperation.servicerequest.entity.Request;
import com.storeOperation.servicerequest.entity.RequestDetails;

public class ServiceRequestDto {
	private Request request;
	private List<RequestDetails> reqDetailsList;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public List<RequestDetails> getReqDetailsList() {
		return reqDetailsList;
	}
	public void setReqDetailsList(List<RequestDetails> reqDetailsList) {
		this.reqDetailsList = reqDetailsList;
	}
	public ServiceRequestDto(Request request, List<RequestDetails> reqDetailsList) {
		super();
		this.request = request;
		this.reqDetailsList = reqDetailsList;
	}
	public ServiceRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
