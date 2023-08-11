package com.storeOperation.dailychecklist.service;

import com.storeOperation.dailychecklist.entity.EndDayChecklist;


public interface EndDayChecklistService {
	String endcheckListadd(EndDayChecklist endCheckList);
	EndDayChecklist viewendCheckList(String date);
	EndDayChecklist updateEndChecklist(String date,EndDayChecklist endDayChecklist);

}
