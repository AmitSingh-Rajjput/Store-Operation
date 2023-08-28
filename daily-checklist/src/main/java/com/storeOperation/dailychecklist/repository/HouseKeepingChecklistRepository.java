package com.storeOperation.dailychecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.HousekeepingChecklist;

public interface HouseKeepingChecklistRepository extends JpaRepository<HousekeepingChecklist, Long> {
	
	HousekeepingChecklist findByCheckListType(String checkListType);

}
