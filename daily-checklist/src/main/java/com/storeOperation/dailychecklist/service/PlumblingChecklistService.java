package com.storeOperation.dailychecklist.service;

import java.util.List;

import com.storeOperation.dailychecklist.entity.PlumblingChecklist;
import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;

public interface PlumblingChecklistService {
	
	String createPlumblingChecklist(PlumblingChecklist checklist);
	List<PlumblingChecklist> getAllPlumbingChecklist();
	List<TaskPlumblingChecklist> addTaskPlumbingChecklist(List<TaskPlumblingChecklist> taskChecklist);
	List<TaskPlumblingChecklist> getbyDateTaskPlumbling(String date);

}
