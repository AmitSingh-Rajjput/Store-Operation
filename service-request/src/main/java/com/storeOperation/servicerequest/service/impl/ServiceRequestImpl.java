package com.storeOperation.servicerequest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.servicerequest.dto.ServiceRequestDto;
import com.storeOperation.servicerequest.entity.Request;
import com.storeOperation.servicerequest.entity.RequestCategory;
import com.storeOperation.servicerequest.entity.RequestDetails;
import com.storeOperation.servicerequest.entity.RequestSubCategory;
import com.storeOperation.servicerequest.entity.RequestUpdateAction;
import com.storeOperation.servicerequest.exception.UserExceptionHandler;
import com.storeOperation.servicerequest.repository.ReqSubCategoryRepository;
import com.storeOperation.servicerequest.repository.RequestCategoryRepository;
import com.storeOperation.servicerequest.repository.RequestDetailsRepostiory;
import com.storeOperation.servicerequest.repository.RequestRepository;
import com.storeOperation.servicerequest.repository.RequestUpdateActionRepository;
import com.storeOperation.servicerequest.service.ServiceRequestService;
import com.storeOperation.servicerequest.util.Utils;

@Service
public class ServiceRequestImpl implements ServiceRequestService{
	
	@Autowired
	private RequestRepository reqRepo;
	
	@Autowired
	private RequestDetailsRepostiory reqDetailRepo;
	
	@Autowired
	private RequestUpdateActionRepository reqActionRepo;
	
	@Autowired
	private RequestCategoryRepository reqCategoryRepo;
	
	@Autowired
	private ReqSubCategoryRepository reqsubCategoryRepo;
	

	@Override
	public String addServiceRequest(Request req) {
        Request reqNew = new Request();
        reqNew.setReqName(req.getReqName());
        reqNew.setReqPhoneNo(req.getReqPhoneNo());
        reqNew.setReqEmail(req.getReqEmail());
        reqNew.setReqAddress(req.getReqAddress());
        reqNew.setDate(req.getDate());
        reqNew.setFile(req.getFile());
        reqNew.setReqCategory(req.getReqCategory());
        reqNew.setReqSubCategory(req.getReqSubCategory());
        reqNew.setReqReason(req.getReqReason());
        reqNew.setRequestId(req.getRequestId());
        reqNew.setReqDescription(req.getReqDescription());
        
        reqRepo.save(req);
        
        RequestDetails reqNewDetail = new RequestDetails();
        reqNewDetail.setRequest(req);
        reqNewDetail.setAction("Service request logged!");
        reqNewDetail.setTechnicalNotes("NA");
        reqNewDetail.setUpdatedate(req.getDate());
        
        reqDetailRepo.save(reqNewDetail);
        
        RequestUpdateAction reqUpadetAction = new RequestUpdateAction();
        
        reqUpadetAction.setRequest(req);
        reqUpadetAction.setStatus("In Progress");
        reqUpadetAction.setUpdatestatusdate(req.getDate());
        
        reqActionRepo.save(reqUpadetAction);
        
		return "Request Raised sucessfully!!";
	}

	@Override
	public List<RequestUpdateAction> viewAllRequest() {
		List<RequestUpdateAction> listReq = reqActionRepo.findAll();
		if(listReq.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No request found!!");
		}
		return listReq;
	}

	@Override
	public ServiceRequestDto detailRequestInfo(String req_id) {
		Request req = reqRepo.findByRequestId(req_id);
		if(req == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No request found!!");
		}
		List<RequestDetails> reqDetail = reqDetailRepo.findByRequest(req);
		ServiceRequestDto serviceDto = new ServiceRequestDto();
		serviceDto.setRequest(req);
		serviceDto.setReqDetailsList(reqDetail);
		return serviceDto;	
	}

	@Override
	public String addCategorty(String reqCategory) {
		RequestCategory req = reqCategoryRepo.findByReqCategory(reqCategory);
		if(req != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Category is already exist!");
		}
		RequestCategory requestCat = new RequestCategory();
		requestCat.setReqCategory(reqCategory);
		reqCategoryRepo.save(requestCat);
		return "Category added sucessfully!";
	}

	@Override
	public String addSubCategory(String category, String subCategory) {
		RequestCategory req = reqCategoryRepo.findByReqCategory(category);
		if(req == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Category is not present!");
		}
		RequestSubCategory reqSubCategory = new RequestSubCategory();
		reqSubCategory.setReqCategory(req);
		reqSubCategory.setSubCategorty(subCategory);
		reqsubCategoryRepo.save(reqSubCategory);
		return "Sub category added sucessfully!";
	}

	@Override
	public List<RequestSubCategory> showAllSubCategory() {
		List<RequestSubCategory> allcategory = reqsubCategoryRepo.findAll();
		return allcategory;
	}


}
