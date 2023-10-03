package com.storeOperation.bankdeposits.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;
import com.storeOperation.bankdeposits.exception.UserExceptionHandler;
import com.storeOperation.bankdeposits.repository.BankDepositDetailRepository;
import com.storeOperation.bankdeposits.repository.BankDepositRepository;
import com.storeOperation.bankdeposits.service.BankDepositService;


@Service
public class BankDepositServiceImpl implements BankDepositService {
	
	@Autowired
	private BankDepositRepository bankDepositRepo;
	
	@Autowired
	private BankDepositDetailRepository bankDepositDetailRepo;

	@Override
	public String addBankDeposit(BankDeposits bankDeposit) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(bankDeposit.getDate());
		if(savedDeposit != null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request already exist!! You can only update!");
		}
		
		BankDeposits savedDepositDetail = bankDepositRepo.save(bankDeposit);
		return "Bank deposit saved sucessfully!";
	}

	@Override
	public String addBankDetailsDeposite(String date,String storeName, BankDepositsDetails bankdepositDetails) {
		BankDeposits savedDeposit = bankDepositRepo.findByDateAndStoreName(date,storeName);
		if(savedDeposit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request not exist!!");
		}
		savedDeposit.setStatus("Completed");
		bankDepositRepo.save(savedDeposit);
		BankDepositsDetails detailAdded = bankDepositDetailRepo.save(new BankDepositsDetails(bankdepositDetails.getDate(), bankdepositDetails.getHandOverDocumentNumber(), savedDeposit));
		
		return "Added bank Deposit detail sucessfully!";
		
	}

	@Override
	public BankDepositView viewDetail(String date) {
		BankDeposits savedDeposit = bankDepositRepo.findByDate(date);
		if(savedDeposit == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Request not exist!!");
		}
		
		BankDepositsDetails bankDetailsDeposit = bankDepositDetailRepo.findByBankDeposit(savedDeposit);
		
		return new BankDepositView(savedDeposit, bankDetailsDeposit.getHandOverDocumentNumber());
		
	}

	@Override
	public List<BankDeposits> viewAllBankDeposits(String storeName) {
		// TODO Auto-generated method stub
		return bankDepositRepo.findByStoreName(storeName);
	}

}
