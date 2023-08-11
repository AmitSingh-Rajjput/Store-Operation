package com.storeOperation.dailychecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.StartDayChecklist;

public interface StartDayRepository extends JpaRepository<StartDayChecklist, Long> {
	
	StartDayChecklist findByDate(String date);

}
