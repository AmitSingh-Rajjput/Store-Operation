package com.storeOperations.labeloperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.ItemLabel;
import com.storeOperations.labeloperations.entity.SelfLabel;

import java.util.List;


public interface ItemLabelRepository extends JpaRepository<ItemLabel, Long> {
	
	List<ItemLabel> findBySelfLabel(SelfLabel selfLabel);
	ItemLabel findByItemCode(String itemCode);

}
