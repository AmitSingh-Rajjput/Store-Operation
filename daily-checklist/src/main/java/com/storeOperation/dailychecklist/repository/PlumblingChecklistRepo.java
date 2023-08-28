package com.storeOperation.dailychecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.PlumblingChecklist;

public interface PlumblingChecklistRepo extends JpaRepository<PlumblingChecklist, Long> {
	
	PlumblingChecklist findByPlumblingChecklistName(String checklistName);

}
