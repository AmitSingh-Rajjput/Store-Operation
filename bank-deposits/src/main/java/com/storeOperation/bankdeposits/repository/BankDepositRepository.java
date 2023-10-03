package com.storeOperation.bankdeposits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.bankdeposits.entity.BankDeposits;

public interface BankDepositRepository extends JpaRepository<BankDeposits, Long>{

	BankDeposits findByDateAndStoreName(String date,String storeName);
	List<BankDeposits> findByStoreName(String storeName);
	BankDeposits findByDate(String date);
}
