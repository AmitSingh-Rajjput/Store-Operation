package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByProductSku(String sku);
	
	List<Product> findByProductType(String catgeory);
	
	List<Product> findByProductSkuContainingIgnoreCase(String sku);

	
}
