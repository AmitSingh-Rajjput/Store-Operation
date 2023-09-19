package com.storeOperation.servicerequest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storeOperation.servicerequest.dto.ServiceRequestDto;
import com.storeOperation.servicerequest.entity.Request;
import com.storeOperation.servicerequest.entity.RequestCategory;
import com.storeOperation.servicerequest.entity.RequestSubCategory;
import com.storeOperation.servicerequest.entity.RequestUpdateAction;


public interface ServiceRequestService {
	
	String addServiceRequest(Request req);
	
	List<RequestUpdateAction> viewAllRequest();
	
	ServiceRequestDto detailRequestInfo(String req_id);
	
//	String updateServiceRequest(String req_id,);
	
	String addCategorty(String reqCategory);
	
	String addSubCategory(String category,String subCategory);
	
	List<RequestSubCategory> showAllSubCategory();

}
