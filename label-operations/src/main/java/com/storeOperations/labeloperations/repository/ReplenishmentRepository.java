package com.storeOperations.labeloperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.Replenishment;

public interface ReplenishmentRepository extends JpaRepository<Replenishment, Long> {

}
