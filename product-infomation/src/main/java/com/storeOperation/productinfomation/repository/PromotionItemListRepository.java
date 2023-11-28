package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.PromotionItemList;
import com.storeOperation.productinfomation.Entity.PromotionList;

public interface PromotionItemListRepository extends JpaRepository<PromotionItemList, Long> {
	
	List<PromotionItemList> findByPromotionList(PromotionList promolist);
	List<PromotionItemList> findByProduct(Product product);

}
