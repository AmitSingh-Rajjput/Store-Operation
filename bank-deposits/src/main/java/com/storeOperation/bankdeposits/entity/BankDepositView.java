package com.storeOperation.bankdeposits.entity;

public class BankDepositView {
	
	private BankDeposits bankdeposit;
	private String handOverNumber;
	public BankDeposits getBankdeposit() {
		return bankdeposit;
	}
	public void setBankdeposit(BankDeposits bankdeposit) {
		this.bankdeposit = bankdeposit;
	}
	public String getHandOverNumber() {
		return handOverNumber;
	}
	public void setHandOverNumber(String handOverNumber) {
		this.handOverNumber = handOverNumber;
	}
	public BankDepositView(BankDeposits bankdeposit, String handOverNumber) {
		super();
		this.bankdeposit = bankdeposit;
		this.handOverNumber = handOverNumber;
	}
	public BankDepositView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
