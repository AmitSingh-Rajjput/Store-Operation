package com.storeOperation.bankdeposits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;

public interface BankDepositDetailRepository extends JpaRepository<BankDepositsDetails, Long>{

	BankDepositsDetails findByBankDeposit(BankDeposits bankDeposit);
}
