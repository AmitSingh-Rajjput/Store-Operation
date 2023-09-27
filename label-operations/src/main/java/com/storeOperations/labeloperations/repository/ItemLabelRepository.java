package com.storeOperations.labeloperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.ItemLabel;

public interface ItemLabelRepository extends JpaRepository<ItemLabel, Long> {

}
