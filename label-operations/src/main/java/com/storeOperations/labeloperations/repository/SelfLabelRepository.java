package com.storeOperations.labeloperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.SelfLabel;
import java.util.List;


public interface SelfLabelRepository extends JpaRepository<SelfLabel, Long>{

	SelfLabel findBySelfLabelIdAndStoreName(String selfLabelId, String storeName);
	List<SelfLabel> findByStoreName(String storeName);
}
