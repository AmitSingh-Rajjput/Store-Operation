package com.storeOperation.servicerequest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.servicerequest.dto.ServiceRequestDto;
import com.storeOperation.servicerequest.entity.Request;
import com.storeOperation.servicerequest.entity.RequestCategory;
import com.storeOperation.servicerequest.entity.RequestSubCategory;
import com.storeOperation.servicerequest.entity.RequestUpdateAction;
import com.storeOperation.servicerequest.service.ServiceRequestService;

@RestController
@RequestMapping("/api/serviceRequest")
public class ServiceRequestController {
	
	@Autowired
	private ServiceRequestService serviceRequest;
	
	
	@PostMapping("/addRequest")
	public ResponseEntity<String> createRequest(@RequestBody Request req){
		String addReq = serviceRequest.addServiceRequest(req);
		return new ResponseEntity<>(addReq,HttpStatus.CREATED);
	}
	
	@GetMapping("/ViewAllRequest")
	public ResponseEntity<List<RequestUpdateAction>> AllRequest(){
		List<RequestUpdateAction> addReq = serviceRequest.viewAllRequest();
		return new ResponseEntity<>(addReq,HttpStatus.OK);
	}
	
	@GetMapping("/ViewAllRequest/{reqId}")
	public ResponseEntity<ServiceRequestDto> ViewDetailRequest(@PathVariable("reqId") String reqId){
		ServiceRequestDto addReq = serviceRequest.detailRequestInfo(reqId);
		return new ResponseEntity<>(addReq,HttpStatus.OK);
	}
	
	@PostMapping("/addReqCategory/{req}")
	public ResponseEntity<String> createCategory(@PathVariable("req") String req){
		String addReq = serviceRequest.addCategorty(req);
		return new ResponseEntity<>(addReq,HttpStatus.CREATED);
	}
	
	@PostMapping("/addReqSubCategory/{cat}/{subCat}")
	public ResponseEntity<String> createSubCategory(@PathVariable("cat") String cat,@PathVariable("subCat") String subcat){
		String addReq = serviceRequest.addSubCategory(cat,subcat);
		return new ResponseEntity<>(addReq,HttpStatus.CREATED);
	}
	
	@GetMapping("/showAllCategorty")
	public ResponseEntity<List<RequestSubCategory>> showAllCategory(){
		List<RequestSubCategory> showCat = serviceRequest.showAllSubCategory();
		return new ResponseEntity<>(showCat,HttpStatus.OK);
	}
	

}
