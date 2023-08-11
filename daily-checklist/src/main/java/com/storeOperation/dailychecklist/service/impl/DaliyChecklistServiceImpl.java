package com.storeOperation.dailychecklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.dailychecklist.DailyChecklistApplication;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.exception.UserExceptionHandler;
import com.storeOperation.dailychecklist.repository.StartDayRepository;
import com.storeOperation.dailychecklist.service.DaliyChecklistService;


@Service
public class DaliyChecklistServiceImpl implements DaliyChecklistService {
	
	@Autowired
	private StartDayRepository startDayRepository;

	@Override
	public String startcheckListadd(StartDayChecklist startCheckList) {
	       StartDayChecklist dailyCheckList = startDayRepository.findByDate(startCheckList.getDate());				
		if(dailyCheckList != null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Checklist is already filled! You can now update only!");
    }			
		
		StartDayChecklist saved =  startDayRepository.save(startCheckList);
		return "Successfully added starting day checklist!";
		
	}

	@Override
	public StartDayChecklist viewStartCheckList(String date) {
		StartDayChecklist dailyCheckList = startDayRepository.findByDate(date);				
		if(dailyCheckList == null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No checklist found!");
    }			
		
		return dailyCheckList;
	}

	@Override
	public StartDayChecklist updateStartChecklist(String date,StartDayChecklist startDayChecklist) {
		StartDayChecklist dailyCheckList = startDayRepository.findByDate(date);				
		if(dailyCheckList == null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No checklist found!");
    }		
		dailyCheckList.setFloatingAmount(startDayChecklist.getFloatingAmount());
		dailyCheckList.setNoOfBackendStaff(startDayChecklist.getNoOfBackendStaff());
		dailyCheckList.setNoOfCashier(startDayChecklist.getNoOfCashier());
		dailyCheckList.setStoreSafeAmount(startDayChecklist.getStoreSafeAmount());
		dailyCheckList.setStoreTime(startDayChecklist.getStoreTime());
		
		StartDayChecklist updatechecklist = startDayRepository.save(dailyCheckList);
		return updatechecklist;
		
	}

}
