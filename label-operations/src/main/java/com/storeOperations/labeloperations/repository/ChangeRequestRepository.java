package com.storeOperations.labeloperations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.ChangeRequest;

public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {
	List<ChangeRequest> findByStoreName(String storeName);

}
