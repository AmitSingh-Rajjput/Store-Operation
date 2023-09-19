package com.storeOperation.servicerequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.servicerequest.entity.RequestCategory;

public interface RequestCategoryRepository extends JpaRepository<RequestCategory, Long>{
	
	RequestCategory findByReqCategory(String reqCategory);

}
