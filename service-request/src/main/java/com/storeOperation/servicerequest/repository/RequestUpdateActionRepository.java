package com.storeOperation.servicerequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.servicerequest.entity.RequestUpdateAction;

public interface RequestUpdateActionRepository extends JpaRepository<RequestUpdateAction,Long>{
    
	
}
