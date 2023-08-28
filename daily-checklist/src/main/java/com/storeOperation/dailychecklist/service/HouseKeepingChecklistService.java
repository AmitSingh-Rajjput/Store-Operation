package com.storeOperation.dailychecklist.service;

import java.util.List;

import com.storeOperation.dailychecklist.dto.SUbChecklistDto;
import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;

public interface HouseKeepingChecklistService {
	
	String addHouseChecklist(HousekeepingChecklist houseKeepingChecklist);
	String addSubHouseChecklist(SUbChecklistDto subChecklistDto);
	List<TaskHousekeepingChecklist> addTaskHouseChecklist(List<TaskHousekeepingChecklist> taskHouseChecklist);
	List<TaskHousekeepingChecklist> getTaskDoneHouseChecklist(String date,String checkListId,String storeName);
	List<HousekeepingChecklist> getHouseKeeping();
	List<SubHousekeepingChecklist> getAllSubHouseKeepingChecklist(String checklistType);

}
