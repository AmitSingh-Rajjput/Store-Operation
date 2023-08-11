package com.storeOperation.dailychecklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.dailychecklist.entity.EndDayChecklist;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.exception.UserExceptionHandler;
import com.storeOperation.dailychecklist.repository.EndDayRepository;
import com.storeOperation.dailychecklist.service.EndDayChecklistService;

@Service
public class EndChecklistServiceImpl implements EndDayChecklistService {
	
	@Autowired
	private EndDayRepository endDayRepository;

	@Override
	public String endcheckListadd(EndDayChecklist endCheckList) {
		EndDayChecklist enddailyCheckList = endDayRepository.findByDate(endCheckList.getDate());				
		if(enddailyCheckList != null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Checklist is already filled! You can now update only!");
    }			
		
		EndDayChecklist saved =  endDayRepository.save(endCheckList);
		return "Successfully added end day checklist!";
	}

	@Override
	public EndDayChecklist viewendCheckList(String date) {
		EndDayChecklist dailyCheckList = endDayRepository.findByDate(date);				
		if(dailyCheckList == null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No checklist found!");
    }			
		
		return dailyCheckList;
	}

	@Override
	public EndDayChecklist updateEndChecklist(String date, EndDayChecklist endDayChecklist) {
		EndDayChecklist dailyCheckList = endDayRepository.findByDate(date);				
		if(dailyCheckList == null) {
		throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No checklist found!");
    }		
		dailyCheckList.setBankDepositDone(endDayChecklist.getBankDepositDone());
		dailyCheckList.setEodCashAmount(endDayChecklist.getEodCashAmount());
		dailyCheckList.setStoreClose(endDayChecklist.getStoreClose());
		dailyCheckList.setStoreSafeAmount(endDayChecklist.getStoreSafeAmount());
		
		EndDayChecklist updatechecklist = endDayRepository.save(dailyCheckList);
		return updatechecklist;
	}

}
