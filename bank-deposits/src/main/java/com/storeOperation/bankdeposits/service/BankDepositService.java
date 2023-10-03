package com.storeOperation.bankdeposits.service;

import java.util.List;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;

public interface BankDepositService {
	
	String addBankDeposit(BankDeposits bankDeposit);
	String addBankDetailsDeposite(String date,String storeName,BankDepositsDetails bankdepositDetails);
	BankDepositView viewDetail(String date);
	List<BankDeposits> viewAllBankDeposits(String storeName);

}
