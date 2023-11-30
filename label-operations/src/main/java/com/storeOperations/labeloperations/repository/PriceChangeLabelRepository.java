package com.storeOperations.labeloperations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.PriceChangeLabel;

public interface PriceChangeLabelRepository extends JpaRepository<PriceChangeLabel, Long> {
	
	List<PriceChangeLabel> findByDate(String date);

}
