package com.storeOperation.dailychecklist.service;

import com.storeOperation.dailychecklist.entity.StartDayChecklist;

public interface DaliyChecklistService {
	
	String startcheckListadd(StartDayChecklist startCheckList);
	StartDayChecklist viewStartCheckList(String date);
	StartDayChecklist updateStartChecklist(String date,StartDayChecklist startDayChecklist);

}
