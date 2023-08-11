package com.storeOperation.dailychecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.EndDayChecklist;


public interface EndDayRepository  extends JpaRepository<EndDayChecklist, Long> {
	
	EndDayChecklist findByDate(String date);

}
