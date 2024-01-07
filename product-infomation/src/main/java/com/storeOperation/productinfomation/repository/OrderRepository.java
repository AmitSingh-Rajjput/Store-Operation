package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {
	List<OrderTable> findByYearAndStoreName(String year,String storeName);
	
	List<OrderTable> findByYearAndMonthAndStoreName(String year,String month,String storeName);
	
	List<OrderTable> findByDateAndStoreName(String date,String storeName);
	
	List<OrderTable> findByOrderStatusAndStoreNameAndYear(String orderStatus,String storeName,String year);
	
	List<OrderTable> findByOrderStatusAndStoreNameAndYearAndMonth(String orderStatus,String storeName,String year,String month);
	
	List<OrderTable> findByOrderStatusAndStoreNameAndDate(String orderStatus,String storeName,String date);
	
	List<OrderTable> findByPaymentModeAndStoreNameAndYear(String mode,String store,String year);
	
	List<OrderTable> findByPaymentModeAndStoreNameAndYearAndMonth(String mode,String store,String year,String month);
	
	List<OrderTable> findByPaymentModeAndStoreNameAndDate(String mode,String store,String date);
	
	List<OrderTable> findByStaffNameAndStoreName(String name,String storeName);
	
	List<OrderTable> findByStaffNameAndStoreNameAndDate(String name,String storeName,String date);
	
	List<OrderTable> findByStaffNameAndStoreNameAndMonthAndYear(String name,String storeName,String month,String year);
	

}
