package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.SubHousekeepingChecklist;
import com.storeOperation.dailychecklist.entity.TaskHousekeepingChecklist;

public interface SubHousekeepingChecklistRepository extends JpaRepository<SubHousekeepingChecklist, Long>{

	SubHousekeepingChecklist findBySubChecklistName(String subchecklistName);
	List<SubHousekeepingChecklist> findByHousekeepingChecklistType(String houseKeepingType);
}
