package com.storeOperation.userregistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.userregistration.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
	
	Store findByStoreName(String storeName);
	Optional<Store> findById(Long id);

}
