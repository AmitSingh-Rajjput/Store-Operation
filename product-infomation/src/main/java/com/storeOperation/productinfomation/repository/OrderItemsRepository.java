package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.OrderItems;
import com.storeOperation.productinfomation.Entity.OrderTable;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long>{
	
	List<OrderItems> findByOrder(OrderTable order);

}
