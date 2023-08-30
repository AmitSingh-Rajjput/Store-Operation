package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

	List<ProductDetails> findByproductAndStore(Product prod,String store);
	List<ProductDetails> findByproduct(Product prod);
}
