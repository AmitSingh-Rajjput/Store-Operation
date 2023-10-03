package com.storeOperation.bankdeposits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.bankdeposits.entity.BankDepositView;
import com.storeOperation.bankdeposits.entity.BankDeposits;
import com.storeOperation.bankdeposits.entity.BankDepositsDetails;
import com.storeOperation.bankdeposits.service.BankDepositService;



@RestController
@RequestMapping("/api/bankDeposit")
public class BankDepositController {
	
	@Autowired
	private BankDepositService bankDepositService;
	
	@PostMapping("/addBankDeposit")
	public ResponseEntity<String> createBankDeposit(@RequestBody BankDeposits bankDeposit){
		String savedDetails = bankDepositService.addBankDeposit(bankDeposit);
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);
	}
	
	@PostMapping("/addBankDepositDetails/{date}/{storeName}")
	public ResponseEntity<String> createBankDepositDetails(@RequestBody BankDepositsDetails bankDeposit,@PathVariable("date") String date,@PathVariable("storeName") String storeName){
		String savedDetails = bankDepositService.addBankDetailsDeposite(date,storeName,bankDeposit);
		return new ResponseEntity<>(savedDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/view/bankDeposit/{date}")
	public ResponseEntity<BankDepositView> seeBankDeposit(@PathVariable String date){
		BankDepositView bankDeposit = bankDepositService.viewDetail(date);
		return new ResponseEntity<>(bankDeposit,HttpStatus.OK);
	}
	
	@GetMapping("/view/AllbankDeposit/{storeName}")
	public ResponseEntity<List<BankDeposits>> seeAllBankDeposit(@PathVariable String storeName){
		List<BankDeposits> bankDeposit = bankDepositService.viewAllBankDeposits(storeName);
		return new ResponseEntity<>(bankDeposit,HttpStatus.OK);
	}
	
	
	
	

}
