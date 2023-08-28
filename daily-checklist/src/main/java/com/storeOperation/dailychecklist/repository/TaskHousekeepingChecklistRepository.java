package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;

public interface TaskHousekeepingChecklistRepository extends JpaRepository<TaskHousekeepingChecklist, Long> {
	
	List<TaskHousekeepingChecklist> findByDateAndCheckListIdAndStoreName(String date,String checkListId,String storeName);
	List<TaskHousekeepingChecklist> findByDate(String date);
	List<TaskHousekeepingChecklist> findByCheckListId(String checkListId);
	List<TaskHousekeepingChecklist> findByStoreName(String storeName);
	TaskHousekeepingChecklist findBySubChecklistId(String subCheckListId);
	
}
