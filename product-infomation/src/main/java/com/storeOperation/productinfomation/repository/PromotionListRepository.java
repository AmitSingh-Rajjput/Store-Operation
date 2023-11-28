package com.storeOperation.productinfomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.PromotionList;

public interface PromotionListRepository extends JpaRepository<PromotionList, Long> {

	PromotionList findByPromotionId(String id);
}
