package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.TaskPlumblingChecklist;

public interface TaskPlumblingChecklistRepo extends JpaRepository<TaskPlumblingChecklist, Long>{
	
	List<TaskPlumblingChecklist> findByDate(String date);
}
